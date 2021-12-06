package com.altmetrik.assignment.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.altmetrik.assignment.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

	/**
	 * returns the product of element next and alternate to provided index.
	 * 
	 * @param index
	 * @return {@link Integer}
	 */
	@Override
	public Integer getProductValueByIndex(int index) {
		LOGGER.info("ProductServiceImpl - getProductValueByIndex call start with index: {}", index);
		
		List<Integer> listOfProducts = Arrays.asList(0, 1, 2, 3, 4, 5, 6); // can be dynamic
		Integer result = 0;

		try {
			if (index == listOfProducts.size() - 1)
				return listOfProducts.get(index);
			else if (index <= listOfProducts.size())
				result = getProductValue(index, listOfProducts);

		} catch (ArrayIndexOutOfBoundsException e) {
			LOGGER.error("ProductServiceImpl - getProductValueByIndex call end with error message: {}", e);
			return result;
		}

		LOGGER.info("ProductServiceImpl - getProductValueByIndex call end with result: {} ", result);
		return result;
	}

	private Integer getProductValue(int index, List<Integer> listOfProducts) {
		Optional<Integer> nextValueToIndex = Optional.ofNullable(listOfProducts.get(index + 1));
		Optional<Integer> nextAlternateValueToIndex = Optional.empty();
		try {
			nextAlternateValueToIndex = Optional.ofNullable(listOfProducts.get(index + 3));
		} catch (ArrayIndexOutOfBoundsException e) {
			return nextValueToIndex.get();
		}
		// get next index and one alternate to it.
		return nextValueToIndex.isPresent() && nextAlternateValueToIndex.isPresent()
				? nextValueToIndex.get() * nextAlternateValueToIndex.get()
				: nextAlternateValueToIndex.orElse(0);

	}

}
