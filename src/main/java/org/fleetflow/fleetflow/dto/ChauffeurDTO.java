package org.fleetflow.fleetflow.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public class ChauffeurDTO {

        private Long id;

        private String name;
        private String phoneNumber;
        private String licenseType;

        private Boolean available;
    }

