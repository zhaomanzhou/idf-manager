package com.idofast.admin.controller;

import com.idofast.admin.exception.BusinessErrorEnum;
import com.idofast.common.response.ServerResponse;
import com.idofast.common.response.exception.BusinessException;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/error/")
@Api(tags = "业务逻辑无关api")
@CrossOrigin
public class ErrorController
{
    @RequestMapping(value = "/unlogin")
    public ServerResponse<String> unlogin() throws BusinessException
    {
        throw new BusinessException(BusinessErrorEnum.NEED_LOGIN);

    }

    /**
     * 权限级别不够
     * @param request
     * @return
     * @throws BusinessException
     */
    @RequestMapping("/unauth")
    public ServerResponse<String> unauth(HttpServletRequest request) throws BusinessException
    {
        String reason = (String) request.getAttribute("reason");
        if(StringUtils.isNotEmpty(reason))
        {
            throw new BusinessException(reason);
        }else
        {
            throw new BusinessException(BusinessErrorEnum.OUT_OF_AUTORITY);
        }
    }
}
