package com.blue.web.services;

import com.blue.web.infrastructure.repositories.impl.BlueRepositoryImpl;
import com.blue.web.webapi.dtos.ReportDTO;
import com.blue.web.webapi.dtos.VotesPerEnterpriseReportDTO;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class BlueService {

    private final BlueRepositoryImpl blueRepository;

    public BlueService(BlueRepositoryImpl blueRepository) {
        this.blueRepository = blueRepository;
    }

    public ReportDTO getReport() {
        ReportDTO reportDTO = new ReportDTO();

        List<VotesPerEnterpriseReportDTO> list = new ArrayList<>();

        VotesPerEnterpriseReportDTO leJardinVote = new VotesPerEnterpriseReportDTO(BigInteger.ZERO, "Le Jardin", blueRepository.totalVotesLE_JARDIM());
        VotesPerEnterpriseReportDTO evianVote = new VotesPerEnterpriseReportDTO(BigInteger.ONE, "Evian", blueRepository.totalVotesEVIAN());
        VotesPerEnterpriseReportDTO olimpiaThermasVote = new VotesPerEnterpriseReportDTO(BigInteger.TWO, "Olímpia Thermas", blueRepository.totalVotesOLIMPIA_THERMAS());

        list.add(leJardinVote);
        list.add(evianVote);
        list.add(olimpiaThermasVote);

        reportDTO.setTotalVotes(blueRepository.totalVotes());
        reportDTO.setVotesPerEnterprise(list);
        reportDTO.setVoteReport(blueRepository.getReport());

        return reportDTO;
    }
}