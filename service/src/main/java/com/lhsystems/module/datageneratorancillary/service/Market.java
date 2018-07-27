package com.lhsystems.module.datageneratorancillary.service;

/**
 * Defines the market in which an airport lies and therefore a flight acts.
 *
 * @author REJ
 * @version $Revision: 1.10 $
 */
public enum Market {
    /**
     * Domestic Market
     */
    DOMESTIC,
    /**
     * Continental Market
     */
    CONTINENTAL,
    /**
     * Intercontinental Market
     */
    INTERCONTINENTAL;

    /**
     * Returns the "bigger" of two <code>markets</code>. Here the following
     * Order is considered DOMESTIC < CONTINENTAL < INTERCONTINENTAL.
     *
     * @param other
     *            the market we compare <code>this </code> to.
     * @return the bigger <code>market</code>.
     */
    public final Market getMaximumMarket(final Market other) {
        if (this.compareTo(other) >= 0) {
            return this;
        } else {
            return other;
        }
    }

}
