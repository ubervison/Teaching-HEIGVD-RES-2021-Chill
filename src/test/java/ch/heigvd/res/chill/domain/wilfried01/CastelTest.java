package ch.heigvd.res.chill.domain.wilfried01;

import ch.heigvd.res.chill.domain.Bartender;
import ch.heigvd.res.chill.domain.wasadigi.Boxer;
import ch.heigvd.res.chill.protocol.OrderRequest;
import ch.heigvd.res.chill.protocol.OrderResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CastelTest {

  @Test
  void thePriceAndNameForCastelShouldBeCorrect() {
    Castel beer = new Castel();
    assertEquals(beer.getName(), Castel.NAME);
    assertEquals(beer.getPrice(), Castel.PRICE);
  }

  @Test
  void aBartenderShouldAcceptAnOrderForCastel() {
    Bartender jane = new Bartender();
    String productName = "ch.heigvd.res.chill.domain.wilfried01.Castel";
    OrderRequest request = new OrderRequest(3, productName);
    OrderResponse response = jane.order(request);
    BigDecimal expectedTotalPrice = Castel.PRICE.multiply(new BigDecimal(3));
    assertEquals(expectedTotalPrice, response.getTotalPrice());
  }

}