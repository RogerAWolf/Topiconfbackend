package nl.topicus.topiconfbackend.rest;

import nl.topicus.topiconfbackend.domain.EmailDetails;
import nl.topicus.topiconfbackend.persistence.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// Annotation
@RestController
// Class
public class EmailEndpoint {

    @Autowired private EmailService emailService;

    // Sending a simple Email
    @PostMapping("/email/emailVersturen")
    public String emailVersturen(@RequestBody EmailDetails details)
    {
        String status
                = emailService.sendSimpleMail(details);

        return status;
    }

    // Sending email with attachment
    @PostMapping("/email/emailMetAttachmentVersturen")
    public String emailMetAttachmentVersturen(
            @RequestBody EmailDetails details)
    {
        String status
                = emailService.sendMailWithAttachment(details);

        return status;
    }
}

