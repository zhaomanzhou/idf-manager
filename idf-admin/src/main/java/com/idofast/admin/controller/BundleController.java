package com.idofast.admin.controller;

import com.idofast.admin.annotation.AuthRole;
import com.idofast.admin.controller.vo.response.BundleVo;
import com.idofast.admin.domain.Bundle;
import com.idofast.admin.service.BundleService;
import com.idofast.common.enums.RoleEnum;
import com.idofast.common.response.ServerResponse;
import com.idofast.common.response.error.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/1/25 9:43 下午
 */
@RestController
@RequestMapping("/bundle")
@Api(tags = "套餐相关的api")
@CrossOrigin
@Slf4j
public class BundleController
{

    @Autowired
    private BundleService bundleService;

    @PostMapping("/admin/add")
    @ApiOperation("添加新的套餐")
    public ServerResponse<String> addBundle(BundleVo bundleVo)
    {
        Bundle bundle = new Bundle();
        BeanUtils.copyProperties(bundleVo, bundle);
        bundleService.addBundle(bundle);
        return ServerResponse.success();    
    }

    @GetMapping("/list")
    @ApiOperation("获取可用的套餐列表")
    public ServerResponse<List<BundleVo>> getActivePackageBundleList()
    {
        List<Bundle> allBundles = bundleService.getAllPackageBundles(true);
        List<BundleVo> collect = allBundles.stream().map(BundleVo::convertFrom)
                .collect(Collectors.toList());
        return ServerResponse.success(collect);

    }

    @GetMapping("/admin/list")
    @ApiOperation("获取所有的的套餐列表")
    public ServerResponse<List<BundleVo>> getAllPackageBundleList()
    {
        List<Bundle> allBundles = bundleService.getAllPackageBundles(false);
        List<BundleVo> collect = allBundles.stream().map(BundleVo::convertFrom)
                .collect(Collectors.toList());
        return ServerResponse.success(collect);

    }

    @GetMapping("/detail")
    @ApiOperation("根据套餐id获取套餐详情")
    public ServerResponse<BundleVo> getBundleById(Long id) throws BusinessException
    {
        Bundle bundle = bundleService.findById(id);
        if(bundle.getActive() == false)
        {
            throw new BusinessException("套餐不存在");
        }
        return ServerResponse.success(BundleVo.convertFrom(bundle));
    }

    @GetMapping("/admin/detail")
    @ApiOperation("根据套餐id获取套餐详情,需要管理员权限，可用获取到下架的套餐")
    @AuthRole(RoleEnum.ADMIN)
    public ServerResponse<BundleVo> getBundleByIdOfAdmin(Long id) throws BusinessException
    {
        Bundle bundle = bundleService.findById(id);
        return ServerResponse.success(BundleVo.convertFrom(bundle));
    }


    @PostMapping("/admin/update")
    @ApiOperation("修改套餐信息")
    @AuthRole(RoleEnum.ADMIN)
    public ServerResponse<String>  updateBundle(@RequestBody BundleVo bundleVo)
    {
        Bundle bundle = new Bundle();
        BeanUtils.copyProperties(bundleVo, bundle);
        bundle.setCreateTime(null);
        bundle.setUpdateTime(null);
        bundleService.updateBundle(bundle);
        return ServerResponse.success();
    }


    @PostMapping("/admin/delete")
    @ApiOperation("删除套餐信息")
    @AuthRole(RoleEnum.ADMIN)
    public ServerResponse<String> deleteBundle(Long id)
    {
        bundleService.deleteBundle(id);
        return ServerResponse.success();
    }




}
