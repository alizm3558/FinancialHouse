package com.alibakir.financialHouse;



import com.alibakir.financialHouse.controller.TransactionReportController;
import com.alibakir.financialHouse.domain.Dto.ReportRequestDto;
import com.alibakir.financialHouse.domain.Dto.TransactionRequestDto;
import com.alibakir.financialHouse.service.AuthService;
import com.alibakir.financialHouse.service.RequestService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
@WebMvcTest(TransactionReportController.class)
class TransactionReportControllerTest {



    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RestTemplate restTemplate;

    @MockBean
    private AuthService authService;

    @MockBean
    private RequestService requestService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetClient() throws Exception {
        String transactionId = "1010993-1539329656-1293";

        TransactionRequestDto requestDto = new TransactionRequestDto();
        requestDto.setTransactionId(transactionId);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/client")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"transactionId\": \"" + transactionId + "\"}"))
                .andExpect(status().isOk());

        System.out.println("---Test Başarılı---");

    }

    @Test
    void testGetTransactionReport() throws Exception {

        ReportRequestDto requestDto = new ReportRequestDto();
        requestDto.setFromDate("2015-01-01");
        requestDto.setToDate("2024-01-31");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/transactions/report")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isOk());


        System.out.println("---Test Başarılı---");

    }
    @Test
    void testGetTransactionList() throws Exception {

        ReportRequestDto requestDto = new ReportRequestDto();
        requestDto.setFromDate("2015-01-01");
        requestDto.setToDate("2024-01-31");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/transactions/list")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isOk());


        System.out.println("---Test Başarılı---");

    }

    @Test
    void testGetTransaction() throws Exception {
        String transactionId = "1010993-1539329656-1293";

        TransactionRequestDto requestDto = new TransactionRequestDto();
        requestDto.setTransactionId(transactionId);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/transaction")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"transactionId\": \"" + transactionId + "\"}"))
                .andExpect(status().isOk());

        System.out.println("---Test Başarılı---");

    }

}