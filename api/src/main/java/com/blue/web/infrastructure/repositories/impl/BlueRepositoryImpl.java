package com.blue.web.infrastructure.repositories.impl;

import com.blue.web.infrastructure.repositories.GenericoRepositoryImplementation;
import com.blue.web.webapi.dtos.EnterpriseReportDTO;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public class BlueRepositoryImpl extends GenericoRepositoryImplementation {

    public BigInteger totalVotes() {
        NativeQuery<BigInteger> nativeQuery = getSession().createNativeQuery("select count(vote_id) as \"Total de votos\" from users;");
        return nativeQuery.getSingleResult();
    }

    public BigInteger totalVotesLE_JARDIM() {
        NativeQuery<BigInteger> nativeQuery = getSession().createNativeQuery("select count(vote) from users inner join vote on users.vote_id = vote.id where enterprise = 0;");
        return nativeQuery.getSingleResult();
    }

    public BigInteger totalVotesEVIAN() {
        NativeQuery<BigInteger> nativeQuery = getSession().createNativeQuery("select count(vote) from users inner join vote on users.vote_id = vote.id where enterprise = 1;");
        return nativeQuery.getSingleResult();
    }

    public BigInteger totalVotesOLIMPIA_THERMAS() {
        NativeQuery<BigInteger> nativeQuery = getSession().createNativeQuery("select count(vote) from users inner join vote on users.vote_id = vote.id where enterprise = 2;");
        return nativeQuery.getSingleResult();
    }

    public List<EnterpriseReportDTO> getReport() {
        NativeQuery<EnterpriseReportDTO> nativeQuery = getSession().createNativeQuery("select name, email, vote.enterprise from users inner join vote on users.vote_id = vote.id;");
        return nativeQuery.getResultList();
    }


}
