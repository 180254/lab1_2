package pl.com.bottega.ecommerce.sales.domain.invoicing;

public interface TaxCalculator {

	public Tax calulateTax(RequestItem item);
}