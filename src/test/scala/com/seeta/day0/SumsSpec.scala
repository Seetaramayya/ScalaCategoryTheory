package com.seeta.day0

import com.seeta.base.BaseSpec

class SumsSpec extends BaseSpec {

  "Sums" should {
    "return correct values for base sum" in {
      Sums.sum1(List(1, 2, 3)) shouldBe 6
    }

    "return correct values for base sum with IntMonoid" in {
      Sums.sum2(List(1, 2, 3)) shouldBe 6
    }

    "return correct values for base sum with implict int monoid as param" in {
      Sums.sum3(List(1, 2, 3)) shouldBe 6
    }

    "return correct values for multiplication with context bound implicit int monoid" in {
      Sums.sum4(List("1", "2", "3")) shouldBe "123"
    }
  }
}
