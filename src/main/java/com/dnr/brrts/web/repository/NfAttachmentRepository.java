package com.dnr.brrts.web.repository;

import com.dnr.brrts.web.model.NfAttachment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NfAttachmentRepository  extends CrudRepository<NfAttachment, Long> {


    List<NfAttachment> findByAttachmentId(Long AttachmentId);

    NfAttachment save(NfAttachment attachment);
}
