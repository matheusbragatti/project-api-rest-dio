package com.matheushdb.projectapirestdio.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BillDTO {

    private Long id;

    private String billName;

    private Long billValue;

}
