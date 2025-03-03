package com.lhsystems.module.datageneratorancillary.service.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Defines the prices in a BaggageClass.
 *
 * @author REJ
 * @version $Revision: 1.10 $
 */
@Entity
@Table(name = "BaggagePricing")
public final class BaggagePricing {

    /** The id of the pricing model. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /** The price of each additional bag. */
    @Column(name = "PRICE_ADDITIONAL_BAG")
    private final double priceAdditionalBag;

    /** The price of the first bag. */
    @Column(name = "PRICE_FIRST_BAG")
    private final double priceFirstBag;

    /** The price of the second bag. */
    @Column(name = "PRICE_SECOND_BAG")
    private final double priceSecondBag;

    /**
     * Default Constructor needed for an Entity. Instantiates a new baggage
     * class.
     */
    public BaggagePricing() {
        priceFirstBag = 0;
        priceSecondBag = 0;
        priceAdditionalBag = 0;
    }

    /**
     * Instantiates a new baggage pricing.
     *
     * @param firstPrice
     *            the first bag price
     * @param secondPrice
     *            the second bag price
     * @param additionalPrice
     *            the additional bag price
     */
    public BaggagePricing(final double firstPrice,
            final double secondPrice, final double additionalPrice) {
        priceFirstBag = firstPrice;
        priceSecondBag = secondPrice;
        priceAdditionalBag = additionalPrice;
    }

    /**
     * Gets the additional bag price.
     *
     * @return the additional price
     */
    public double getAdditionalPrice() {
        return priceAdditionalBag;
    }

    /**
     * Gets the first bag price.
     *
     * @return the first price
     */
    public double getFirstPrice() {
        return priceFirstBag;
    }

    /**
     * returns the id.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Gets the second bag price.
     *
     * @return the second price
     */
    public double getSecondPrice() {
        return priceSecondBag;
    }
}