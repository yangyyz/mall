package com.linyangkai.mallproduct.service;
import com.linyangkai.mallproduct.entity.BrandEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class BrandServiceTest {
  @Autowired
  BrandService brandService;
  @Test
  void queryPage() {
    BrandEntity brandEntity = new BrandEntity();
    brandEntity.setName("华为");
    brandService.save(brandEntity);
  }
}
