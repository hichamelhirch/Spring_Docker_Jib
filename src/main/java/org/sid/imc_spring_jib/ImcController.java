package org.sid.imc_spring_jib;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@AllArgsConstructor
@RestController

@RequestMapping(path = "imc")

public class ImcController {

    public  ImcService imcService;
    @PostMapping
    public @ResponseBody Map<String,String> calculate(@RequestBody ImcDTO data){
        return imcService.calculate(data);
    }
}
