package pl.com.bottega.ecommerce.sales.domain.taxing;

import java.math.BigDecimal;

import pl.com.bottega.ecommerce.sales.domain.invoicing.RequestItem;
import pl.com.bottega.ecommerce.sharedkernel.Money;

public class StandardTaxCalculator implements TaxCalculator {

	public Tax calulateTax(RequestItem item) {
		BigDecimal ratio = null;
		String desc = null;

		switch (item.getProductData().getType()) {
		case DRUG:
			ratio = BigDecimal.valueOf(0.05);
			desc = "5% (D)";
			break;
		case FOOD:
			ratio = BigDecimal.valueOf(0.07);
			desc = "7% (F)";
			break;
		case STANDARD:
			ratio = BigDecimal.valueOf(0.23);
			desc = "23%";
			break;

		default:
			throw new IllegalArgumentException(item.getProductData().getType() + " not handled");
		}
		Money net = item.getTotalCost();
		Money taxValue = net.multiplyBy(ratio);

		return new Tax(taxValue, desc);
	}

}
