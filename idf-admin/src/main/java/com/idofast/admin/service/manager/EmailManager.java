package com.idofast.admin.service.manager;

import com.google.common.collect.Maps;
import com.idofast.admin.domain.EmailSendHistory;
import com.idofast.admin.infrastructure.EmailAdapter;
import com.idofast.admin.repository.EmailSendHistoryRepository;
import com.idofast.common.enums.EmailTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

@Service
@Slf4j
public class EmailManager
{
    @Autowired
    private EmailAdapter emailAdapter;
    @Autowired
    private EmailSendHistoryRepository emailSendHistoryRepository;
    @Autowired
    private EmailLockManager emailLockManager;

    @Value("${switch.sendEmail}")
    private boolean sendEmail;


    public void sendVcode(String toEmail, String vcode, EmailTypeEnum emailTypeEnum) throws UnsupportedEncodingException, MessagingException
    {
        Map<String, Object> map = Maps.newHashMap();
        map.put("vcode", vcode);
        switch (emailTypeEnum)
        {
            case REGISTER_VCODE : emailAdapter.sendThymeleafMail("IdoFast验证码", toEmail, map, "vcode_register.html"); break;
            case RESET_PASSWORD : emailAdapter.sendThymeleafMail("IdoFast验证码", toEmail, map, "vcode_reset.html"); break;
        }

    }

    @Async
    public void sendMailAndSaveToDb(String toEmail, String vcode, EmailTypeEnum emailTypeEnum) throws Exception
    {

        log.info("开始向{}发送验证码{}", toEmail, vcode);
        if(sendEmail)
        {
            sendVcode(toEmail, vcode, emailTypeEnum);
        }
        emailLockManager.lockUserForVerificationCode(toEmail, vcode);
        log.info("{}的验证码发送成功，开始存入db", toEmail);
        EmailSendHistory history = EmailSendHistory.builder()
                .content(vcode)
                .emailTypeEnum(emailTypeEnum)
                .receiver(toEmail)
                .build();
        emailSendHistoryRepository.save(history);
        log.info("{}的验证码db入库成功", toEmail);

    }
}
