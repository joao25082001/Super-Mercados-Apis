package org.example.entity;

import org.example.DTO.produto.ProdutoBaixoEstoque;
import org.example.enums.EnvioEmail;

import java.time.LocalDateTime;
import java.util.List;

public class Email {
    private Long idEmail ;

    private String emailFrom;
    private String emailTo;

    private String subject;

    private List<ProdutoBaixoEstoque> text;
    private LocalDateTime sendDateEmail;
    private EnvioEmail statusEmail;

    public Email() {
    }

    public Long getIdEmail() {
        return idEmail;
    }

    public void setIdEmail(Long idEmail) {
        this.idEmail = idEmail;
    }


    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<ProdutoBaixoEstoque> getText() {
        return text;
    }

    public void setText(List<ProdutoBaixoEstoque> text) {
        this.text = text;
    }

    public LocalDateTime getSendDateEmail() {
        return sendDateEmail;
    }

    public void setSendDateEmail(LocalDateTime sendDateEmail) {
        this.sendDateEmail = sendDateEmail;
    }

    public EnvioEmail getStatusEmail() {
        return statusEmail;
    }

    public void setStatusEmail(EnvioEmail statusEmail) {
        this.statusEmail = statusEmail;
    }
}
