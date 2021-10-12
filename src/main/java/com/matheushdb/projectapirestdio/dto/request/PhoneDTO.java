package com.matheushdb.projectapirestdio.dto.request;

import com.matheushdb.projectapirestdio.entity.Phone;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {

    private Long id;

    private String type;

    private String number;
}
