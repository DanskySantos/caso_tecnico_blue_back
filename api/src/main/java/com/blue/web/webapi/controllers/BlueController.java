package com.blue.web.webapi.controllers;


import com.blue.web.services.BlueService;
import com.blue.web.webapi.dtos.ReportDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blue")
public class BlueController {

    private final BlueService blueService;

    public BlueController(BlueService blueService) {
        this.blueService = blueService;
    }

    @GetMapping()
    public ReportDTO getVoteData() {

        return this.blueService.getReport();
    }
}
