package com.idofast.proxy.service;


import com.google.gson.Gson;
import com.idofast.common.dto.V2rayAccountDto;
import com.idofast.proxy.V2RayApiClient;
import com.v2ray.core.app.proxyman.command.AddUserOperation;
import com.v2ray.core.app.proxyman.command.AlterInboundRequest;
import com.v2ray.core.app.proxyman.command.AlterInboundResponse;
import com.v2ray.core.app.proxyman.command.RemoveUserOperation;
import com.v2ray.core.common.protocol.SecurityConfig;
import com.v2ray.core.common.protocol.SecurityType;
import com.v2ray.core.common.protocol.User;
import com.v2ray.core.common.serial.TypedMessage;
import com.v2ray.core.proxy.vmess.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class V2rayService
{


    public void rmProxyAccount(String host, Integer port,String email, String tag) {
        try {
            V2RayApiClient client = V2RayApiClient.getInstance(host, port);
            
            TypedMessage rmOp = TypedMessage.newBuilder().setType(RemoveUserOperation.getDescriptor().getFullName())
                    .setValue(RemoveUserOperation.newBuilder().setEmail(email).build().toByteString()).build();
            AlterInboundRequest req = AlterInboundRequest.newBuilder().setTag(tag).setOperation(rmOp).build();
            client.getHandlerServiceBlockingStub().alterInbound(req);
        } catch (Exception e) {
            if (e.getLocalizedMessage().contains("not found"))return;
            e.printStackTrace();
            log.error("rmProxyAccount error:{},{}", e.getLocalizedMessage(), new Gson().toJson(email));
        }
    }

    public void addProxyAccount(String host, Integer port, String tag, V2rayAccountDto proxyAccount) {
        try {
            V2RayApiClient client = V2RayApiClient.getInstance(host, port);
            Account account = Account.newBuilder().setAlterId(1).setId(proxyAccount.getUuid())
                    .setSecuritySettings(SecurityConfig.newBuilder().setType(SecurityType.AUTO).build()).build();

            TypedMessage AccountTypedMsg = TypedMessage.newBuilder().
                    setType(Account.getDescriptor().getFullName()
                    ).setValue(account.toByteString()).build();

            User user = User.newBuilder().setEmail(proxyAccount.getEmail()).setLevel(1).setAccount(AccountTypedMsg).build();
            AddUserOperation addUserOperation = AddUserOperation.newBuilder().setUser(user).build();

            TypedMessage typedMessage = TypedMessage.newBuilder().setType(AddUserOperation.getDescriptor().getFullName())
                    .setValue(addUserOperation.toByteString()).build();

            AlterInboundResponse alterInboundResponse = client.getHandlerServiceBlockingStub().alterInbound(AlterInboundRequest.newBuilder().setTag(tag).setOperation(typedMessage).build());
            System.out.println(alterInboundResponse);
        } catch (Exception e) {
            e.printStackTrace();
            if (e.getLocalizedMessage().contains("already exists")) return;
            log.error("addProxyAccount error:{}", e.getLocalizedMessage());

        }
    }
}
