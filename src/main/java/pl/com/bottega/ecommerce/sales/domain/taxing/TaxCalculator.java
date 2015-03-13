package pl.com.bottega.ecommerce.sales.domain.taxing;

import pl.com.bottega.ecommerce.sales.domain.invoicing.RequestItem;

public interface TaxCalculator {

	public Tax calulateTax(RequestItem item);
}
