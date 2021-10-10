package com.idofast.admin.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.idofast.admin.controller.vo.request.V2rayNodeAddOrUpdateVo;
import com.idofast.admin.controller.vo.response.DirectV2rayNodeVo;
import com.idofast.admin.controller.vo.response.V2rayNodeVo;
import com.idofast.admin.domain.V2rayNode;
import com.idofast.admin.repository.V2rayNodeRepository;
import com.idofast.common.response.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/11 10:41 上午
 */
@Service
public class NodeService
{
    @Autowired
    private V2rayNodeRepository v2rayNodeRepository;
    private V2rayNodeVo v2rayNodeVo;


    /**
     * 添加新v2ray节点
     *
     * @param v2rayNode
     */
    public void addNewV2rayNode(V2rayNode v2rayNode)
    {
        v2rayNodeRepository.save(v2rayNode);
    }



    /**
     * 获取所有直连节点列表， 即parentNodeId为0的节点
     *
     * @return
     */
    public List<DirectV2rayNodeVo> getAllDirectNodes()
    {
        List<DirectV2rayNodeVo> collect = v2rayNodeRepository.getAllByParentNodeIdEquals(0L)
                .stream().map(DirectV2rayNodeVo::convertFrom)
                .collect(Collectors.toList());
        return collect;
    }


    public Optional<V2rayNode> getByHost(String host)
    {
        List<V2rayNode> allByHostEquals = v2rayNodeRepository.findAllByHostEquals(host);
        if (allByHostEquals.size() == 0)
        {
            return Optional.empty();
        }
        return Optional.of(allByHostEquals.get(0));
    }


    /**
     * 获取所有节点列表，管理员视角
     *
     * @return
     */
    public List<V2rayNodeVo> getAllV2rayNodes()
    {
        List<V2rayNode> all = v2rayNodeRepository.findAll();

        //生产一个nodeMap，把所有节点的id和对应的node关联起来
        final Map<Long, V2rayNode> nodeMap = all.stream().
                collect(groupingBy(V2rayNode::getId, collectingAndThen(maxBy((e1, e2) -> 1), Optional::get)));

        List<V2rayNodeVo> collect = all.stream()
                .map(node -> {
                    v2rayNodeVo = V2rayNodeVo.convertFrom(node);
                    if (node.getParentNodeId() == 0L)
                    {
                        return v2rayNodeVo;
                    } else
                    {
                        V2rayNode parent = nodeMap.get(node.getParentNodeId());
                        v2rayNodeVo.setParentHost(parent.getHost());
                        v2rayNodeVo.setParentName(parent.getName());
                        return v2rayNodeVo;

                    }
                })
                .sorted((n1, n2) -> {
                    if (n1.getLevel().equals(n2.getLevel()))
                    {
                        return (int) (n1.getSequence() - n2.getSequence());
                    } else
                    {
                        return n1.getLevel() - n2.getLevel();
                    }
                })
                .collect(toList());


        return collect;

    }


    public void deleteNode(Long id) throws BusinessException
    {
        final List<V2rayNode> allByParentNodeIdEquals = v2rayNodeRepository.getAllByParentNodeIdEquals(id);
        if(allByParentNodeIdEquals.size() > 0)
        {
            throw new BusinessException("该节点尚有未删除的子节点，删除失败");
        }
        v2rayNodeRepository.deleteById(id);
    }

    public void updateNode(V2rayNodeAddOrUpdateVo vo)
    {

        V2rayNode node1 = v2rayNodeRepository.findById(vo.getId()).get();
        BeanUtil.copyProperties(vo, node1, CopyOptions.create().setIgnoreNullValue(true));
        v2rayNodeRepository.save(node1);
    }


    public Map<Integer, List<V2rayNode>> getNodeListForSimpleUser()
    {
        List<V2rayNode> allByEnableEquals = v2rayNodeRepository.findAllByEnableEquals(true);
        Map<Integer, List<V2rayNode>> collect = allByEnableEquals.stream().collect(groupingBy(V2rayNode::getLevel));
        return collect;
    }


}
