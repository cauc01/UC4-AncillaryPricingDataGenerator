package com.lhsystems.module.datageneratorancillary.service.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;



/**
 * The class Airport serves as a model for airports.
 *
 * @author REJ
 * @version $Revision: 1.10 $
 */

@Entity
@Table(name = "Airport")
public final class Airport {

    /**
     * Pattern that every iata airport code should match.
     */
    private static String PATTERN_IATA_AIRPORT_CODE = "[A-Z]{3}";

    /**
     * IATA airport code naming and identifying the airport.
     */
    @Id
    @Column(name = "IATA_CODE")
    private String iataCode;

    /**
     * Market in which the airport lies in.
     */
    @Enumerated(EnumType.STRING)
    private final Market market;

    /**
     * Full name of the airport.
     */
    @Column(name = "NAME")
    private final String name;

    /**
     * Instantiates a new airport.
     *
     * @param paramIataCode
     *            IATA code of the airport.
     * @param paramName
     *            full name of the airport.
     * @param paramMarket
     *            the market in which the airport lies in.
     */
    public Airport(final String paramIataCode, final String paramName,
            final Market paramMarket) {
        name = paramName;
        market = paramMarket;
        setIataCode(paramIataCode);
    }

    /**
     * Default Constructor needed for an Entity. Instantiates a new airport
     * class.
     */
    public Airport() {
        name = "";
        market = Market.DOMESTIC;
        iataCode = "";
    }

    /**
     * Returns the market of the airport object.
     *
     * @return the market of the airport
     */
    public Market getMarket() {
        return market;
    }

    /**
     * Returns the name of the airport object.
     *
     * @return the name of the airport
     */
    public String getName() {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (other.getClass() != getClass()) {
            return false;
        }
        final Airport otherAirport = (Airport) other;
        final EqualsBuilder equalsBuilder = new EqualsBuilder();
        equalsBuilder.append(iataCode, otherAirport.getIata());
        equalsBuilder.append(name, otherAirport.getName());
        equalsBuilder.append(market, otherAirport.getMarket());
        return equalsBuilder.isEquals();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(iataCode).append(name).append(
                market).toHashCode();
    }
    /**
     * Returns the IATA code of the airport object.
     *
     * @return the IATA code of the airport
     */
    public String getIata() {
        return iataCode;
    }

    /**
     * Sets <code>iataCode</code> of this Airport if pattern is correct, throws
     * exception otherwise.
     *
     * @param paramIataCode
     *            new IATA code of the airport
     */
    private void setIataCode(final String paramIataCode) {
        if (paramIataCode.toUpperCase().matches(PATTERN_IATA_AIRPORT_CODE)) {
            iataCode = paramIataCode.toUpperCase();
        } else {
            throw new RuntimeException("Incorrect Iata Code:" + paramIataCode);
        }
    }


}
