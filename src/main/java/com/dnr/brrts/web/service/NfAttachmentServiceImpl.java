package com.dnr.brrts.web.service;


import com.dnr.brrts.web.model.NfAttachment;
import com.dnr.brrts.web.repository.NfAttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NfAttachmentServiceImpl implements NfAttachmentService {

    @Autowired
    NfAttachmentRepository attachmentRepository;
    @Override
    public NfAttachment findAttachmentById(Long attachmentId) {
        return attachmentRepository.findOne(attachmentId);
    }
}
