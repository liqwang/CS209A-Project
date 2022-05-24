package edu.sustech.backend.service;

import org.springframework.stereotype.Service;

@Service
public class UpdateServiceImpl implements UpdateService{

    public UpdateStatus status = UpdateStatus.NOT_INITIATED;
}
