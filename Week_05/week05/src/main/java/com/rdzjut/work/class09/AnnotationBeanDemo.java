package com.rdzjut.work.class09;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component("annotationBeanDemo")
public class AnnotationBeanDemo {
    @Value("1")
    private Long id;

    @Value("rendzjut")
    private String name;

    @Value("25")
    private Integer age;

}
