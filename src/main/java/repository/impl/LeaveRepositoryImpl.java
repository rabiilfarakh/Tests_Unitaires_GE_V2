package repository.impl;

import dao.GenericDaoImpl;
import entity.Leave;
import jakarta.persistence.PersistenceContext;

import java.util.UUID;

@PersistenceContext
public class LeaveRepositoryImpl extends GenericDaoImpl<Leave, UUID> {
    public LeaveRepositoryImpl() {
        super(Leave.class);
    }
}
