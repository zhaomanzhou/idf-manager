package com.idofast.admin.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.idofast.admin.controller.vo.request.V2rayNodeAddOrUpdateVo;
import com.idofast.admin.controller.vo.response.DirectV2rayNodeVo;
import com.idofast.admin.controller.vo.response.V2rayNodeVo;
import com.idofast.admin.domain.V2rayNode;
import com.idofast.admin.repository.V2rayNodeRepository;
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
     * @param v2rayNode
     */
    public void addNewV2rayNode(V2rayNode v2rayNode)
    {
        v2rayNode.setMessageForAdmin("");
        v2rayNodeRepository.save(v2rayNode);
    }

    /**
     * 获取所有直连节点列表， 即parentNodeId为0的节点
     * @return
     */
    public List<DirectV2rayNodeVo> getAllDirectNodes()
    {
        List<DirectV2rayNodeVo> collect = v2rayNodeRepository.getAllByParentNodeIdEquals(0L)
                .stream().map(DirectV2rayNodeVo::convertFrom)
                .collect(Collectors.toList());
        return collect;
    }


    public List<V2rayNodeVo> getAllV2rayNodes()
    {
        List<V2rayNode> all = v2rayNodeRepository.findAll();
        final Map<Long, V2rayNode> nodeMap = all.stream().
                collect(groupingBy(V2rayNode::getId, collectingAndThen(maxBy((e1, e2) -> 1), Optional::get)));

        List<V2rayNodeVo> collect = all.stream()
                .map(node ->{
                    v2rayNodeVo = V2rayNodeVo.convertFrom(node);
                    if(node.getParentNodeId() == 0L)
                    {
                        return v2rayNodeVo;
                    }else
                    {
                        V2rayNode parent = nodeMap.get(node.getParentNodeId());
                        v2rayNodeVo.setParentHost(parent.getHost());
                        v2rayNodeVo.setParentName(parent.getName());
                        return v2rayNodeVo;

                    }
                })
                .collect(toList());

        return collect;

    }


    public void deleteNode(Long id)
    {
        v2rayNodeRepository.deleteById(id);
    }

    public void updateNode(V2rayNodeAddOrUpdateVo vo)
    {

        V2rayNode node1 = v2rayNodeRepository.findById(vo.getId()).get();
        BeanUtil.copyProperties(vo, node1, CopyOptions.create().setIgnoreNullValue(true));
        v2rayNodeRepository.save(node1);
    }




}
