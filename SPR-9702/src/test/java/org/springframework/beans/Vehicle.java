package org.springframework.beans;

import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Vehicle {

    private static final long serialVersionUID = 1162154324L;

    private transient boolean previousSupportEnabled = false;
    private transient Vehicle previous = null;
    private transient Integer additionalInsuredCount;
    private transient List Objects;
    private transient List allGaragedAddresses;
    private transient Boolean allOtherClassIndicator;
    private transient List allVehicleCustomizations;
    private transient String annualMilesCode;
    private transient String antiTheftDevice;
    private transient Boolean atRatedLocationIndicator;
    private transient String autoRateClassCode;
    private transient Integer averageBusinessMilesWeekly;
    private transient String brakeTypeCode;
    private transient String businessDrivenForMiles;
    private transient Boolean businessDrivenInd;
    private transient String businessMerchandiseCarryDesc;
    private transient Boolean businessOwnedIndicator;
    private transient Object businessOwnerIntegration;
    private transient String businessTransportDesc;
    private transient Boolean businessTransportInd;
    private transient Boolean businessUsage;
    private transient Boolean businessUsageInd;
    private transient String businessUsagePercent;
    private transient String businessUsageTypeCode;
    private transient String businessUseClassificationCode;
    private transient java.math.BigDecimal businessUsePercentage;
    private transient String businessVehiclePullsTrailer;
    private transient Boolean businessVehiclePullsTrailerInd;
    private transient Boolean businessVehicleUsedForHire;
    private transient String carVanPoolInd;
    private transient String catastropheCode;
    private transient String cededIndicator;
    private transient String classAssignmentMethodCode;
    private transient String collisionClassCode;
    private transient String comments;
    private transient java.math.BigDecimal commercialDriverRatingFactor;
    private transient String commuteSurchargeState;
    private transient String commuteSurchargeStateCode;
    private transient java.math.BigDecimal costNewAmount;
    private transient Boolean costNewCustomizationsIndicator;
    private transient List coverageRestrictions;
    private transient List coverages;
    private transient java.math.BigDecimal currentOdometerAmount;
    private transient Date currentOdometerDate;
    private transient java.math.BigDecimal customizationAmount;
    private transient Integer customizationsCount;
    private transient Boolean customizedIndicator;
    private transient String dayTimeRunningLights;
    private transient Integer daysWeekVehDrivenSchool;
    private transient Integer daysWeekVehDrivenWork;
    private transient Boolean daytimeRunningLightsIndicator;
    private transient String decode;
    private transient Object deletedBusinessOwnerIntegration;
    private transient Object deletedGaragedAddressIntegration;
    private transient List deletedGaragedAddresses;
    private transient String description;
    private transient Integer driverOwnerNumber1;
    private transient Integer driverOwnerNumber2;
    private transient String driverTrainingApplies;
    private transient String driverVehicleClassCode;
    private transient Integer electronicCustomizationAmount;
    private transient Boolean eligibleIndicator;
    private transient String employedByGarageIndicator;
    private transient String engineSizeCubicCcCode;
    private transient Integer estimatedAnnualMileage;
    private transient Boolean excessVehicleIndicator;
    private transient String extendedNonOwnerCode;
    private transient Boolean failedVinIndicator;
    private transient Boolean femaleRateClassIndicator;
    private transient String finalRiskTerritoryCode;
    private transient Boolean financedIndicator;
    private transient List forms;
    private transient String garageCityGNISCode;
    private transient Object garagedAddressIntegration;
    private transient Object garagedGeocodedAddressIntegration;
    private transient String geographicCityCode;
    private transient String goodDriverCode;
    private transient String grossWeight;
    private transient String hasAntiLockBrakes;
    private transient String hasAutoSeatBelt;
    private transient String hasDriverSideAirBag;
    private transient String hasPassengerAirBag;
    private transient String highTheftCode;
    private transient Boolean historicalVehicleIndicator;
    private transient Float householdCompositeFactor;
    private transient Boolean hybridInd;
    private transient String individualCorporateOwnershipCode;
    private transient Boolean inspectionConsent;
    private transient String inspectionRequiredIndicator;
    private transient String inspectionSite1Code;
    private transient String inspectionSite2Code;
    private transient String inspectionStatusCode;
    private transient Date inspectionStatusDate;
    private transient String inspectionStatusReasonCode;
    private transient String insuranceLineCode;
    private transient String isCustomized;
    private transient Boolean isGaragedAtDifferentLocation;
    private transient String isOtherThanStandardRate;
    private transient String isUsedForBusiness;
    private transient String keptInGarageIndicator;
    private transient Boolean leasedIndicator;
    private transient String legacyMeritCode;
    private transient String liabilitySymbolCode;
    private transient String liabilitySymbolOverrideCode;
    private transient Integer lienHolderCount;
    private transient List logicallyDeletedBusinessOwners;
    private transient Date lossDate;
    private transient Boolean manualRateIndicator;
    private transient String materialHauledCode;
    private transient String mbiGroupCode;
    private transient Date mbiOriginalInceptionDate;
    private transient String mbiRefusalCode;
    private transient String motorcycleLendingFrequencyCode;
    private transient String motorcycleStorageCode;
    private transient java.math.BigDecimal msrpAmount;
    private transient String multiCarOverride;
    private transient Boolean multicarDiscountIndicator;
    private transient Integer nonElectronicCustomizationAmount;
    private transient Integer numberOfInterestedParties;
    private transient Integer numberOfMilesToSchool;
    private transient Integer numberOfMilesToWork;
    private transient Integer numberOfOwners;
    private transient java.math.BigDecimal numberOfVehicleApcPoints;
    private transient String occurrenceLocation;
    private transient List operators;
    private transient Integer originalReplacedVehicleUnitNumber;
    private transient Boolean otherInterestPartyIndicator;
    private transient String overMAIPIndicator;
    private transient Boolean owner1RegisteredNameIndicator;
    private transient Boolean owner2RegisteredNameIndicator;
    private transient String paVehSubtypeCode;
    private transient String paVehicleFutureUseCode3;
    private transient Date paVehicleFutureUseDate1;
    private transient String paVehicleFutureUseIndicator5;
    private transient String paVehicleFutureUseIndicator6;
    private transient Object paVehicleHistorizationAttributes;
    private transient String passiveRestraintCode;
    private transient java.math.BigDecimal pavePurchaseAmount;
    private transient String physicalVehicleTypeCode;
    private transient String policyId;
    private transient String policySurchargeInd;
    private transient List premiumDiscounts;
    private transient String previousCityCode;
    private transient String previousGarageZipCode;
    private transient String previousLiabilitySymbolCode;
    private transient String previousPhysicalDamageSymCode;
    private transient String previousPhysicalDamageSymCode2;
    private transient String primaryIndustryClassificationCode;
    private transient String primaryIndustrySubClassificationCode;
    private transient String primaryLiabilityIndicator;
    private transient Object priorInsurerIntegration;
    private transient Integer priorTermAnnualMileage;
    private transient String priorYearCityCode;
    private transient String priorYearPostalCode;
    private transient String priorYearRiskTerritoryCode;
    private transient String purchaseCode;
    private transient Date purchaseDate;
    private transient Boolean purchaseLastThirtyDaysIndicator;
    private transient Integer ratedDriverNumber;
    private transient String ratedOperatorTypeCode;
    private transient String rearAxlesOnCommercialVehicle;
    private transient String registeredOwnerZipcode;
    private transient String registeredStateCode;
    private transient String removalReasonCode;
    private transient Integer replacedVehicleUnitNumber;
    private transient String replacementVehicleIdentifierCode;
    private transient Date requestedRemovalDate;
    private transient String restrictedCoverageReasonCode;
    private transient String restrictedCoverageTypeCode;
    private transient String restrictedVehicleCode;
    private transient String riskCityName;
    private transient String riskCountyCode;
    private transient String riskStateCode;
    private transient String riskStatisticalCode;
    private transient String riskTerritoryCode;
    private transient String riskTerritoryConfidencePercent;
    private transient String riskZipCode;
    private transient Integer rvDaysOccupiedPerYear;
    private transient String soleOwnerResponseCode;
    private transient java.math.BigDecimal statedAmount;
    private transient String statisticReportingCode;
    private transient Boolean structuralModificationIndicator;
    private transient String style;
    private transient String symbolOverrideCode;
    private transient String symbolOverrideCode2;
    private transient Date tagSurrenderDate;
    private transient String tagSurrenderReceiptNumber;
    private transient String taxLocationCode;
    private transient String taxLocationConfidencePercent;
    private transient String taxLocationLowConfidence;
    private transient String taxLocationOverrideCode;
    private transient String taxLocationSource;
    private transient String temporaryVehicleVinNumber;
    private transient String territoryCodeSourceSystemCode;
    private transient String territoryOverrideCode;
    private transient Boolean tortIndicator;
    private transient Boolean undeleted;
    private transient String vandalismTheftCode;
    private transient String vehicleAgeGroupCode;
    private transient String vehicleBodyCode;
    private transient String vehicleBodyStyleCode;
    private transient String vehicleCarPoolIndicator;
    private transient String vehicleConditionCode;
    private transient String vehicleConditionSubtypeCode;
    private transient java.math.BigDecimal vehicleContentsAmount;
    private transient Object vehicleCustomizationIntegration;
    private transient String vehicleDamage;
    private transient String vehicleDrivenForCode;
    private transient String vehicleIsFinanaced;
    private transient String vehicleLocationCode;
    private transient String vehicleMakeCode;
    private transient String vehicleMechanicalBreakdownInsuranceAge;
    private transient String vehicleModelCode;
    private transient Integer vehicleModelYear;
    private transient String vehicleOwnershipCode;
    private transient String vehiclePerformanceCode;
    private transient String vehiclePointsOverrideIndicator;
    private transient Integer vehicleRank;
    private transient String vehicleReasonAmendedCode;
    private transient String vehicleSymbolCode;
    private transient String vehicleSymbolCode2;
    private transient String vehicleTagNumber;
    private transient String vehicleTierCode;
    private transient String vehicleTypeCode;
    private transient Integer vehicleUnitNumber;
    private transient String vehicleUseCode;
    private transient String vehicleUseDrivers;
    private transient Boolean vehicleVinIndicator;
    private transient String vehicleVinNumber;
    private transient String vehicleZipCode;
    private transient Integer year;

    public Vehicle() {}

    private void readObject(final ObjectInputStream in) throws IOException, ClassNotFoundException {}

    private void writeObject(final ObjectOutputStream out) throws IOException {}

    public boolean isPreviousSupportEnabled() {
        return previousSupportEnabled;
    }

    public void setPreviousSupportEnabled(final boolean enabled) {
        previousSupportEnabled = enabled;
    }

    public boolean hasPrevious() {
        return previous != null;
    }

    public Object getFactory() {
        return null;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Integer
     */
    public void setAdditionalInsuredCount(final Integer value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Integer previousValue = getAdditionalInsuredCount();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setAdditionalInsuredCount(previousValue);
            }
        }
        this.additionalInsuredCount = value;
        getPropertyChangeSupport().firePropertyChange("additionalInsuredCount", previousValue,
            getAdditionalInsuredCount());
    }

    /**
     * @return
     */
    private boolean checkReadOnly() {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * Gets the value of additionalInsuredCount.
     * 
     * @return Integer the value located at additionalInsuredCount
     */
    public Integer getAdditionalInsuredCount() {
        return this.additionalInsuredCount;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Object[]
     */
    public void setObjects(final Object[] value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Object[] previousValue = getObjects();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setObjects(previousValue);
            }
        }
        if (this.Objects != null && value == null) {
            if (this.Objects.size() >= 0) {
                this.Objects.clear(); // to help the garbage collector do it's job
                                      // easier.
            }
            this.Objects = null;
        } else {
            if (this.Objects == null) {
                this.Objects = new java.util.ArrayList(value.length);
            }
            if (this.Objects.size() > 0) {
                this.Objects.clear(); // reset/clear current list, we don't want to add
            }
            this.Objects.addAll(Arrays.asList(value));
        }
        getPropertyChangeSupport().firePropertyChange("Objects", previousValue, getObjects());
    }

    /**
     * @param previousInstance
     * @return
     */
    private Vehicle copy() {
        return null;
    }

    /**
     * Sets the value of an array element. Takes no action if read only.
     * 
     * @param index the index into the array
     * @param value the value of type Object[] that will be put into the array
     */
    public void setObjects(final int index, final Object value) {

        if (checkReadOnly()) {
            return;
        }

        final Object[] previousValue = getObjects();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setObjects(index, getObjects(index));
            }
        }
        if (this.Objects == null) {
            this.Objects = new java.util.ArrayList(index + 1);
        } else if (this.Objects.size() < index + 1) {
            this.Objects = resize(this.Objects, index + 1);
        }
        this.Objects.set(index, value);
        getPropertyChangeSupport().firePropertyChange("Objects", previousValue, getObjects());
    }

    /**
     * @return
     */
    private PropertyChangeSupport getPropertyChangeSupport() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param Objects2
     * @param i
     * @return
     */
    private List resize(final List list, final int i) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Adds an element to an array list the value. Takes no action if read only.
     * 
     * @param value sets value of type Object
     */
    public void addObjects(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        final Object[] previousValue = getObjects();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            }
        }
        if (this.Objects == null) {
            this.Objects = new java.util.ArrayList(1);
        }
        this.Objects.add(value);
        getPropertyChangeSupport().firePropertyChange("Objects", previousValue, getObjects());
    }

    /**
     * Removes the value. Takes no action if read only
     * 
     * @param value of type Object
     */
    public void removeObjects(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            }
        }
        if (this.Objects != null && value != null) {
            this.Objects.remove(value);
        }
        getPropertyChangeSupport().firePropertyChange("Objects", value, null);
    }

    /**
     * Gets the value of Objects.
     * 
     * @return Object[] as an array. Never returns null.
     */
    public Object[] getObjects() {
        if (this.Objects == null) {
            this.Objects = new java.util.ArrayList();
        }
        return Objects.toArray(new Object[this.Objects.size()]);
    }

    /**
     * Gets a value from an array.
     * 
     * @param index location in the array to retrieve from}
     * @return Object the value located at location index in Objects Returns null if the array is
     *         empty or the index is out of bounds
     */
    public Object getObjects(final int index) {
        if (Objects == null || Objects.size() < index + 1) {
            return null;
        }
        return Objects.get(index);
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type ObjectIntegration[]
     */
    public void setObjectsIntegration(final Object[] value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Object[] previousValue = getObjectsIntegration();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setObjectsIntegration(previousValue);
            }
        }
        if (this.Objects != null && value == null) {
            if (this.Objects.size() >= 0) {
                this.Objects.clear(); // to help the garbage collector do it's job
                                      // easier.
            }
            this.Objects = null;
        } else {
            if (this.Objects == null) {
                this.Objects = new java.util.ArrayList(value.length);
            }
            if (this.Objects.size() > 0) {
                this.Objects.clear(); // reset/clear current list, we don't want to add
            }
            this.Objects.addAll(Arrays.asList(value));
        }
        getPropertyChangeSupport().firePropertyChange("Objects", previousValue,
            getObjectsIntegration());
    }

    /**
     * Sets the value of an array element. Takes no action if read only.
     * 
     * @param index the index into the array
     * @param value the value of type ObjectIntegration[] that will be put into the array
     */
    public void setObjectsIntegration(final int index, final Object value) {

        if (checkReadOnly()) {
            return;
        }

        final Object[] previousValue = getObjectsIntegration();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setObjectsIntegration(index, getObjectsIntegration(index));
            }
        }
        if (this.Objects == null) {
            this.Objects = new java.util.ArrayList(index + 1);
        } else if (this.Objects.size() < index + 1) {
            this.Objects = resize(this.Objects, index + 1);
        }
        this.Objects.set(index, value);
        getPropertyChangeSupport().firePropertyChange("Objects", previousValue,
            getObjectsIntegration());
    }

    /**
     * Adds an element to an array list the value. Takes no action if read only.
     * 
     * @param value sets value of type ObjectIntegration
     */
    public void addObjectsIntegration(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        final Object[] previousValue = getObjectsIntegration();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            }
        }
        if (this.Objects == null) {
            this.Objects = new java.util.ArrayList(1);
        }
        this.Objects.add(value);
        getPropertyChangeSupport().firePropertyChange("Objects", previousValue,
            getObjectsIntegration());
    }

    /**
     * Removes the value. Takes no action if read only
     * 
     * @param value of type ObjectIntegration
     */
    public void removeObjectsIntegration(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            }
        }
        if (this.Objects != null && value != null) {
            this.Objects.remove(value);
        }
        getPropertyChangeSupport().firePropertyChange("Objects", value, null);
    }

    /**
     * Gets the value of Objects.
     * 
     * @return ObjectIntegration[] as an array. Never returns null.
     */
    public Object[] getObjectsIntegration() {
        if (this.Objects == null) {
            this.Objects = new java.util.ArrayList();
        }
        return Objects.toArray(new Object[this.Objects.size()]);
    }

    /**
     * Gets a value from an array.
     * 
     * @param index location in the array to retrieve from}
     * @return ObjectIntegration the value located at location index in Objects Returns null if the
     *         array is empty or the index is out of bounds
     */
    public Object getObjectsIntegration(final int index) {
        if (Objects == null || Objects.size() < index + 1) {
            return null;
        }
        return Objects.get(index);
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Address[]
     */
    public void setAllGaragedAddresses(final Object[] value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Object[] previousValue = getAllGaragedAddresses();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setAllGaragedAddresses(previousValue);
            }
        }
        if (this.allGaragedAddresses != null && value == null) {
            if (this.allGaragedAddresses.size() >= 0) {
                this.allGaragedAddresses.clear(); // to help the garbage collector do it's job
                                                  // easier.
            }
            this.allGaragedAddresses = null;
        } else {
            if (this.allGaragedAddresses == null) {
                this.allGaragedAddresses = new java.util.ArrayList(value.length);
            }
            if (this.allGaragedAddresses.size() > 0) {
                this.allGaragedAddresses.clear(); // reset/clear current list, we don't want to add
            }
            this.allGaragedAddresses.addAll(Arrays.asList(value));
        }
        getPropertyChangeSupport().firePropertyChange("allGaragedAddresses", previousValue,
            getAllGaragedAddresses());
    }

    /**
     * Sets the value of an array element. Takes no action if read only.
     * 
     * @param index the index into the array
     * @param value the value of type Address[] that will be put into the array
     */
    public void setAllGaragedAddresses(final int index, final Object value) {

        if (checkReadOnly()) {
            return;
        }

        final Object[] previousValue = getAllGaragedAddresses();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setAllGaragedAddresses(index, getAllGaragedAddresses(index));
            }
        }
        if (this.allGaragedAddresses == null) {
            this.allGaragedAddresses = new java.util.ArrayList(index + 1);
        } else if (this.allGaragedAddresses.size() < index + 1) {
            this.allGaragedAddresses = resize(this.allGaragedAddresses, index + 1);
        }
        this.allGaragedAddresses.set(index, value);
        getPropertyChangeSupport().firePropertyChange("allGaragedAddresses", previousValue,
            getAllGaragedAddresses());
    }

    /**
     * Adds an element to an array list the value. Takes no action if read only.
     * 
     * @param value sets value of type Address
     */
    public void addAllGaragedAddresses(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        final Object[] previousValue = getAllGaragedAddresses();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            }
        }
        if (this.allGaragedAddresses == null) {
            this.allGaragedAddresses = new java.util.ArrayList(1);
        }
        this.allGaragedAddresses.add(value);
        getPropertyChangeSupport().firePropertyChange("allGaragedAddresses", previousValue,
            getAllGaragedAddresses());
    }

    /**
     * Removes the value. Takes no action if read only
     * 
     * @param value of type Address
     */
    public void removeAllGaragedAddresses(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            }
        }
        if (this.allGaragedAddresses != null && value != null) {
            this.allGaragedAddresses.remove(value);
        }
        getPropertyChangeSupport().firePropertyChange("allGaragedAddresses", value, null);
    }

    /**
     * Gets the value of allGaragedAddresses.
     * 
     * @return Address[] as an array. Never returns null.
     */
    public Object[] getAllGaragedAddresses() {
        if (this.allGaragedAddresses == null) {
            this.allGaragedAddresses = new java.util.ArrayList();
        }
        return allGaragedAddresses.toArray(new Object[this.allGaragedAddresses.size()]);
    }

    /**
     * Gets a value from an array.
     * 
     * @param index location in the array to retrieve from}
     * @return Address the value located at location index in allGaragedAddresses Returns null if
     *         the array is empty or the index is out of bounds
     */
    public Object getAllGaragedAddresses(final int index) {
        if (allGaragedAddresses == null || allGaragedAddresses.size() < index + 1) {
            return null;
        }
        return allGaragedAddresses.get(index);
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type AddressIntegration[]
     */
    public void setAllGaragedAddressesIntegration(final Object[] value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Object[] previousValue = getAllGaragedAddressesIntegration();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setAllGaragedAddressesIntegration(previousValue);
            }
        }
        if (this.allGaragedAddresses != null && value == null) {
            if (this.allGaragedAddresses.size() >= 0) {
                this.allGaragedAddresses.clear(); // to help the garbage collector do it's job
                                                  // easier.
            }
            this.allGaragedAddresses = null;
        } else {
            if (this.allGaragedAddresses == null) {
                this.allGaragedAddresses = new java.util.ArrayList(value.length);
            }
            if (this.allGaragedAddresses.size() > 0) {
                this.allGaragedAddresses.clear(); // reset/clear current list, we don't want to add
            }
            this.allGaragedAddresses.addAll(Arrays.asList(value));
        }
        getPropertyChangeSupport().firePropertyChange("allGaragedAddresses", previousValue,
            getAllGaragedAddressesIntegration());
    }

    /**
     * Sets the value of an array element. Takes no action if read only.
     * 
     * @param index the index into the array
     * @param value the value of type AddressIntegration[] that will be put into the array
     */
    public void setAllGaragedAddressesIntegration(final int index, final Object value) {

        if (checkReadOnly()) {
            return;
        }

        final Object[] previousValue = getAllGaragedAddressesIntegration();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setAllGaragedAddressesIntegration(index,
                    getAllGaragedAddressesIntegration(index));
            }
        }
        if (this.allGaragedAddresses == null) {
            this.allGaragedAddresses = new java.util.ArrayList(index + 1);
        } else if (this.allGaragedAddresses.size() < index + 1) {
            this.allGaragedAddresses = resize(this.allGaragedAddresses, index + 1);
        }
        this.allGaragedAddresses.set(index, value);
        getPropertyChangeSupport().firePropertyChange("allGaragedAddresses", previousValue,
            getAllGaragedAddressesIntegration());
    }

    /**
     * Adds an element to an array list the value. Takes no action if read only.
     * 
     * @param value sets value of type AddressIntegration
     */
    public void addAllGaragedAddressesIntegration(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        final Object[] previousValue = getAllGaragedAddressesIntegration();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            }
        }
        if (this.allGaragedAddresses == null) {
            this.allGaragedAddresses = new java.util.ArrayList(1);
        }
        this.allGaragedAddresses.add(value);
        getPropertyChangeSupport().firePropertyChange("allGaragedAddresses", previousValue,
            getAllGaragedAddressesIntegration());
    }

    /**
     * Removes the value. Takes no action if read only
     * 
     * @param value of type AddressIntegration
     */
    public void removeAllGaragedAddressesIntegration(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            }
        }
        if (this.allGaragedAddresses != null && value != null) {
            this.allGaragedAddresses.remove(value);
        }
        getPropertyChangeSupport().firePropertyChange("allGaragedAddresses", value, null);
    }

    /**
     * Gets the value of allGaragedAddresses.
     * 
     * @return AddressIntegration[] as an array. Never returns null.
     */
    public Object[] getAllGaragedAddressesIntegration() {
        if (this.allGaragedAddresses == null) {
            this.allGaragedAddresses = new java.util.ArrayList();
        }
        return allGaragedAddresses.toArray(new Object[this.allGaragedAddresses.size()]);
    }

    /**
     * Gets a value from an array.
     * 
     * @param index location in the array to retrieve from}
     * @return AddressIntegration the value located at location index in allGaragedAddresses Returns
     *         null if the array is empty or the index is out of bounds
     */
    public Object getAllGaragedAddressesIntegration(final int index) {
        if (allGaragedAddresses == null || allGaragedAddresses.size() < index + 1) {
            return null;
        }
        return allGaragedAddresses.get(index);
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Boolean
     */
    public void setAllOtherClassIndicator(final Boolean value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Boolean previousValue = getAllOtherClassIndicator();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setAllOtherClassIndicator(previousValue);
            }
        }
        this.allOtherClassIndicator = value;
        getPropertyChangeSupport().firePropertyChange("allOtherClassIndicator", previousValue,
            getAllOtherClassIndicator());
    }

    /**
     * Gets the value of allOtherClassIndicator.
     * 
     * @return Boolean the value located at allOtherClassIndicator
     */
    public Boolean getAllOtherClassIndicator() {
        return this.allOtherClassIndicator;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type VehicleCustomization[]
     */
    public void setAllVehicleCustomizations(final Object[] value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Object[] previousValue = getAllVehicleCustomizations();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setAllVehicleCustomizations(previousValue);
            }
        }
        if (this.allVehicleCustomizations != null && value == null) {
            if (this.allVehicleCustomizations.size() >= 0) {
                this.allVehicleCustomizations.clear(); // to help the garbage collector do it's job
                                                       // easier.
            }
            this.allVehicleCustomizations = null;
        } else {
            if (this.allVehicleCustomizations == null) {
                this.allVehicleCustomizations = new java.util.ArrayList(value.length);
            }
            if (this.allVehicleCustomizations.size() > 0) {
                this.allVehicleCustomizations.clear(); // reset/clear current list, we don't want to
                                                       // add
            }
            this.allVehicleCustomizations.addAll(Arrays.asList(value));
        }
        getPropertyChangeSupport().firePropertyChange("allVehicleCustomizations", previousValue,
            getAllVehicleCustomizations());
    }

    /**
     * Sets the value of an array element. Takes no action if read only.
     * 
     * @param index the index into the array
     * @param value the value of type VehicleCustomization[] that will be put into the array
     */
    public void setAllVehicleCustomizations(final int index, final Object value) {

        if (checkReadOnly()) {
            return;
        }

        final Object[] previousValue = getAllVehicleCustomizations();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious()
                    .setAllVehicleCustomizations(index, getAllVehicleCustomizations(index));
            }
        }
        if (this.allVehicleCustomizations == null) {
            this.allVehicleCustomizations = new java.util.ArrayList(index + 1);
        } else if (this.allVehicleCustomizations.size() < index + 1) {
            this.allVehicleCustomizations = resize(this.allVehicleCustomizations, index + 1);
        }
        this.allVehicleCustomizations.set(index, value);
        getPropertyChangeSupport().firePropertyChange("allVehicleCustomizations", previousValue,
            getAllVehicleCustomizations());
    }

    /**
     * Adds an element to an array list the value. Takes no action if read only.
     * 
     * @param value sets value of type VehicleCustomization
     */
    public void addAllVehicleCustomizations(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        final Object[] previousValue = getAllVehicleCustomizations();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            }
        }
        if (this.allVehicleCustomizations == null) {
            this.allVehicleCustomizations = new java.util.ArrayList(1);
        }
        this.allVehicleCustomizations.add(value);
        getPropertyChangeSupport().firePropertyChange("allVehicleCustomizations", previousValue,
            getAllVehicleCustomizations());
    }

    /**
     * Removes the value. Takes no action if read only
     * 
     * @param value of type VehicleCustomization
     */
    public void removeAllVehicleCustomizations(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            }
        }
        if (this.allVehicleCustomizations != null && value != null) {
            this.allVehicleCustomizations.remove(value);
        }
        getPropertyChangeSupport().firePropertyChange("allVehicleCustomizations", value, null);
    }

    /**
     * Gets the value of allVehicleCustomizations.
     * 
     * @return VehicleCustomization[] as an array. Never returns null.
     */
    public Object[] getAllVehicleCustomizations() {
        if (this.allVehicleCustomizations == null) {
            this.allVehicleCustomizations = new java.util.ArrayList();
        }
        return allVehicleCustomizations.toArray(new Object[this.allVehicleCustomizations.size()]);
    }

    /**
     * Gets a value from an array.
     * 
     * @param index location in the array to retrieve from}
     * @return VehicleCustomization the value located at location index in allVehicleCustomizations
     *         Returns null if the array is empty or the index is out of bounds
     */
    public Object getAllVehicleCustomizations(final int index) {
        if (allVehicleCustomizations == null || allVehicleCustomizations.size() < index + 1) {
            return null;
        }
        return allVehicleCustomizations.get(index);
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type VehicleCustomizationIntegration[]
     */
    public void setAllVehicleCustomizationsIntegration(final Object[] value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Object[] previousValue = getAllVehicleCustomizationsIntegration();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setAllVehicleCustomizationsIntegration(previousValue);
            }
        }
        if (this.allVehicleCustomizations != null && value == null) {
            if (this.allVehicleCustomizations.size() >= 0) {
                this.allVehicleCustomizations.clear(); // to help the garbage collector do it's job
                                                       // easier.
            }
            this.allVehicleCustomizations = null;
        } else {
            if (this.allVehicleCustomizations == null) {
                this.allVehicleCustomizations = new java.util.ArrayList(value.length);
            }
            if (this.allVehicleCustomizations.size() > 0) {
                this.allVehicleCustomizations.clear(); // reset/clear current list, we don't want to
                                                       // add
            }
            this.allVehicleCustomizations.addAll(Arrays.asList(value));
        }
        getPropertyChangeSupport().firePropertyChange("allVehicleCustomizations", previousValue,
            getAllVehicleCustomizationsIntegration());
    }

    /**
     * Sets the value of an array element. Takes no action if read only.
     * 
     * @param index the index into the array
     * @param value the value of type VehicleCustomizationIntegration[] that will be put into the
     *        array
     */
    public void setAllVehicleCustomizationsIntegration(final int index, final Object value) {

        if (checkReadOnly()) {
            return;
        }

        final Object[] previousValue = getAllVehicleCustomizationsIntegration();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setAllVehicleCustomizationsIntegration(index,
                    getAllVehicleCustomizationsIntegration(index));
            }
        }
        if (this.allVehicleCustomizations == null) {
            this.allVehicleCustomizations = new java.util.ArrayList(index + 1);
        } else if (this.allVehicleCustomizations.size() < index + 1) {
            this.allVehicleCustomizations = resize(this.allVehicleCustomizations, index + 1);
        }
        this.allVehicleCustomizations.set(index, value);
        getPropertyChangeSupport().firePropertyChange("allVehicleCustomizations", previousValue,
            getAllVehicleCustomizationsIntegration());
    }

    /**
     * Adds an element to an array list the value. Takes no action if read only.
     * 
     * @param value sets value of type VehicleCustomizationIntegration
     */
    public void addAllVehicleCustomizationsIntegration(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        final Object[] previousValue = getAllVehicleCustomizationsIntegration();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            }
        }
        if (this.allVehicleCustomizations == null) {
            this.allVehicleCustomizations = new java.util.ArrayList(1);
        }
        this.allVehicleCustomizations.add(value);
        getPropertyChangeSupport().firePropertyChange("allVehicleCustomizations", previousValue,
            getAllVehicleCustomizationsIntegration());
    }

    /**
     * Removes the value. Takes no action if read only
     * 
     * @param value of type VehicleCustomizationIntegration
     */
    public void removeAllVehicleCustomizationsIntegration(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            }
        }
        if (this.allVehicleCustomizations != null && value != null) {
            this.allVehicleCustomizations.remove(value);
        }
        getPropertyChangeSupport().firePropertyChange("allVehicleCustomizations", value, null);
    }

    /**
     * Gets the value of allVehicleCustomizations.
     * 
     * @return VehicleCustomizationIntegration[] as an array. Never returns null.
     */
    public Object[] getAllVehicleCustomizationsIntegration() {
        if (this.allVehicleCustomizations == null) {
            this.allVehicleCustomizations = new java.util.ArrayList();
        }
        return allVehicleCustomizations.toArray(new Object[this.allVehicleCustomizations.size()]);
    }

    /**
     * Gets a value from an array.
     * 
     * @param index location in the array to retrieve from}
     * @return VehicleCustomizationIntegration the value located at location index in
     *         allVehicleCustomizations Returns null if the array is empty or the index is out of
     *         bounds
     */
    public Object getAllVehicleCustomizationsIntegration(final int index) {
        if (allVehicleCustomizations == null || allVehicleCustomizations.size() < index + 1) {
            return null;
        }
        return allVehicleCustomizations.get(index);
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setAnnualMilesCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getAnnualMilesCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setAnnualMilesCode(previousValue);
            }
        }
        this.annualMilesCode = value;
        getPropertyChangeSupport().firePropertyChange("annualMilesCode", previousValue,
            getAnnualMilesCode());
    }

    /**
     * Gets the value of annualMilesCode.
     * 
     * @return String the value located at annualMilesCode
     */
    public String getAnnualMilesCode() {
        return this.annualMilesCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setAntiTheftDevice(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getAntiTheftDevice();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setAntiTheftDevice(previousValue);
            }
        }
        this.antiTheftDevice = value;
        getPropertyChangeSupport().firePropertyChange("antiTheftDevice", previousValue,
            getAntiTheftDevice());
    }

    /**
     * Gets the value of antiTheftDevice.
     * 
     * @return String the value located at antiTheftDevice
     */
    public String getAntiTheftDevice() {
        return this.antiTheftDevice;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Boolean
     */
    public void setAtRatedLocationIndicator(final Boolean value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Boolean previousValue = getAtRatedLocationIndicator();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setAtRatedLocationIndicator(previousValue);
            }
        }
        this.atRatedLocationIndicator = value;
        getPropertyChangeSupport().firePropertyChange("atRatedLocationIndicator", previousValue,
            getAtRatedLocationIndicator());
    }

    /**
     * Gets the value of atRatedLocationIndicator.
     * 
     * @return Boolean the value located at atRatedLocationIndicator
     */
    public Boolean getAtRatedLocationIndicator() {
        return this.atRatedLocationIndicator;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setAutoRateClassCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getAutoRateClassCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setAutoRateClassCode(previousValue);
            }
        }
        this.autoRateClassCode = value;
        getPropertyChangeSupport().firePropertyChange("autoRateClassCode", previousValue,
            getAutoRateClassCode());
    }

    /**
     * Gets the value of autoRateClassCode.
     * 
     * @return String the value located at autoRateClassCode
     */
    public String getAutoRateClassCode() {
        return this.autoRateClassCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Integer
     */
    public void setAverageBusinessMilesWeekly(final Integer value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Integer previousValue = getAverageBusinessMilesWeekly();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setAverageBusinessMilesWeekly(previousValue);
            }
        }
        this.averageBusinessMilesWeekly = value;
        getPropertyChangeSupport().firePropertyChange("averageBusinessMilesWeekly", previousValue,
            getAverageBusinessMilesWeekly());
    }

    /**
     * Gets the value of averageBusinessMilesWeekly.
     * 
     * @return Integer the value located at averageBusinessMilesWeekly
     */
    public Integer getAverageBusinessMilesWeekly() {
        return this.averageBusinessMilesWeekly;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setBrakeTypeCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getBrakeTypeCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setBrakeTypeCode(previousValue);
            }
        }
        this.brakeTypeCode = value;
        getPropertyChangeSupport().firePropertyChange("brakeTypeCode", previousValue,
            getBrakeTypeCode());
    }

    /**
     * Gets the value of brakeTypeCode.
     * 
     * @return String the value located at brakeTypeCode
     */
    public String getBrakeTypeCode() {
        return this.brakeTypeCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setBusinessDrivenForMiles(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getBusinessDrivenForMiles();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setBusinessDrivenForMiles(previousValue);
            }
        }
        this.businessDrivenForMiles = value;
        getPropertyChangeSupport().firePropertyChange("businessDrivenForMiles", previousValue,
            getBusinessDrivenForMiles());
    }

    /**
     * Gets the value of businessDrivenForMiles.
     * 
     * @return String the value located at businessDrivenForMiles
     */
    public String getBusinessDrivenForMiles() {
        return this.businessDrivenForMiles;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Boolean
     */
    public void setBusinessDrivenInd(final Boolean value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Boolean previousValue = getBusinessDrivenInd();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setBusinessDrivenInd(previousValue);
            }
        }
        this.businessDrivenInd = value;
        getPropertyChangeSupport().firePropertyChange("businessDrivenInd", previousValue,
            getBusinessDrivenInd());
    }

    /**
     * Gets the value of businessDrivenInd.
     * 
     * @return Boolean the value located at businessDrivenInd
     */
    public Boolean getBusinessDrivenInd() {
        return this.businessDrivenInd;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setBusinessMerchandiseCarryDesc(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getBusinessMerchandiseCarryDesc();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setBusinessMerchandiseCarryDesc(previousValue);
            }
        }
        this.businessMerchandiseCarryDesc = value;
        getPropertyChangeSupport().firePropertyChange("businessMerchandiseCarryDesc",
            previousValue, getBusinessMerchandiseCarryDesc());
    }

    /**
     * Gets the value of businessMerchandiseCarryDesc.
     * 
     * @return String the value located at businessMerchandiseCarryDesc
     */
    public String getBusinessMerchandiseCarryDesc() {
        return this.businessMerchandiseCarryDesc;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Boolean
     */
    public void setBusinessOwnedIndicator(final Boolean value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Boolean previousValue = getBusinessOwnedIndicator();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setBusinessOwnedIndicator(previousValue);
            }
        }
        this.businessOwnedIndicator = value;
        getPropertyChangeSupport().firePropertyChange("businessOwnedIndicator", previousValue,
            getBusinessOwnedIndicator());
    }

    /**
     * Gets the value of businessOwnedIndicator.
     * 
     * @return Boolean the value located at businessOwnedIndicator
     */
    public Boolean getBusinessOwnedIndicator() {
        return this.businessOwnedIndicator;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type BusinessOwner
     */
    public void setBusinessOwner(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Object previousValue = getBusinessOwner();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setBusinessOwner(previousValue);
            }
        }
        this.businessOwnerIntegration = value;
        getPropertyChangeSupport().firePropertyChange("businessOwnerIntegration", previousValue,
            getBusinessOwner());
    }

    /**
     * Gets the value of businessOwnerIntegration.
     * 
     * @return BusinessOwner the value located at businessOwnerIntegration
     */
    public Object getBusinessOwner() {
        return this.businessOwnerIntegration;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type BusinessOwnerIntegration
     */
    public void setBusinessOwnerIntegration(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Object previousValue = getBusinessOwnerIntegration();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setBusinessOwnerIntegration(previousValue);
            }
        }
        this.businessOwnerIntegration = value;
        getPropertyChangeSupport().firePropertyChange("businessOwnerIntegration", previousValue,
            getBusinessOwnerIntegration());
    }

    /**
     * Gets the value of businessOwnerIntegration.
     * 
     * @return BusinessOwnerIntegration the value located at businessOwnerIntegration
     */
    public Object getBusinessOwnerIntegration() {
        return this.businessOwnerIntegration;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setBusinessTransportDesc(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getBusinessTransportDesc();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setBusinessTransportDesc(previousValue);
            }
        }
        this.businessTransportDesc = value;
        getPropertyChangeSupport().firePropertyChange("businessTransportDesc", previousValue,
            getBusinessTransportDesc());
    }

    /**
     * Gets the value of businessTransportDesc.
     * 
     * @return String the value located at businessTransportDesc
     */
    public String getBusinessTransportDesc() {
        return this.businessTransportDesc;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Boolean
     */
    public void setBusinessTransportInd(final Boolean value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Boolean previousValue = getBusinessTransportInd();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setBusinessTransportInd(previousValue);
            }
        }
        this.businessTransportInd = value;
        getPropertyChangeSupport().firePropertyChange("businessTransportInd", previousValue,
            getBusinessTransportInd());
    }

    /**
     * Gets the value of businessTransportInd.
     * 
     * @return Boolean the value located at businessTransportInd
     */
    public Boolean getBusinessTransportInd() {
        return this.businessTransportInd;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Boolean
     */
    public void setBusinessUsage(final Boolean value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Boolean previousValue = getBusinessUsage();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setBusinessUsage(previousValue);
            }
        }
        this.businessUsage = value;
        getPropertyChangeSupport().firePropertyChange("businessUsage", previousValue,
            getBusinessUsage());
    }

    /**
     * Gets the value of businessUsage.
     * 
     * @return Boolean the value located at businessUsage
     */
    public Boolean getBusinessUsage() {
        return this.businessUsage;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Boolean
     */
    public void setBusinessUsageInd(final Boolean value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Boolean previousValue = getBusinessUsageInd();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setBusinessUsageInd(previousValue);
            }
        }
        this.businessUsageInd = value;
        getPropertyChangeSupport().firePropertyChange("businessUsageInd", previousValue,
            getBusinessUsageInd());
    }

    /**
     * Gets the value of businessUsageInd.
     * 
     * @return Boolean the value located at businessUsageInd
     */
    public Boolean getBusinessUsageInd() {
        return this.businessUsageInd;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setBusinessUsagePercent(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getBusinessUsagePercent();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setBusinessUsagePercent(previousValue);
            }
        }
        this.businessUsagePercent = value;
        getPropertyChangeSupport().firePropertyChange("businessUsagePercent", previousValue,
            getBusinessUsagePercent());
    }

    /**
     * Gets the value of businessUsagePercent.
     * 
     * @return String the value located at businessUsagePercent
     */
    public String getBusinessUsagePercent() {
        return this.businessUsagePercent;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setBusinessUsageTypeCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getBusinessUsageTypeCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setBusinessUsageTypeCode(previousValue);
            }
        }
        this.businessUsageTypeCode = value;
        getPropertyChangeSupport().firePropertyChange("businessUsageTypeCode", previousValue,
            getBusinessUsageTypeCode());
    }

    /**
     * Gets the value of businessUsageTypeCode.
     * 
     * @return String the value located at businessUsageTypeCode
     */
    public String getBusinessUsageTypeCode() {
        return this.businessUsageTypeCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setBusinessUseClassificationCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getBusinessUseClassificationCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setBusinessUseClassificationCode(previousValue);
            }
        }
        this.businessUseClassificationCode = value;
        getPropertyChangeSupport().firePropertyChange("businessUseClassificationCode",
            previousValue, getBusinessUseClassificationCode());
    }

    /**
     * Gets the value of businessUseClassificationCode.
     * 
     * @return String the value located at businessUseClassificationCode
     */
    public String getBusinessUseClassificationCode() {
        return this.businessUseClassificationCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type java.math.BigDecimal
     */
    public void setBusinessUsePercentage(final java.math.BigDecimal value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final java.math.BigDecimal previousValue = getBusinessUsePercentage();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setBusinessUsePercentage(previousValue);
            }
        }
        this.businessUsePercentage = value;
        getPropertyChangeSupport().firePropertyChange("businessUsePercentage", previousValue,
            getBusinessUsePercentage());
    }

    /**
     * Gets the value of businessUsePercentage.
     * 
     * @return java.math.BigDecimal the value located at businessUsePercentage
     */
    public java.math.BigDecimal getBusinessUsePercentage() {
        return this.businessUsePercentage;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setBusinessVehiclePullsTrailer(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getBusinessVehiclePullsTrailer();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setBusinessVehiclePullsTrailer(previousValue);
            }
        }
        this.businessVehiclePullsTrailer = value;
        getPropertyChangeSupport().firePropertyChange("businessVehiclePullsTrailer", previousValue,
            getBusinessVehiclePullsTrailer());
    }

    /**
     * Gets the value of businessVehiclePullsTrailer.
     * 
     * @return String the value located at businessVehiclePullsTrailer
     */
    public String getBusinessVehiclePullsTrailer() {
        return this.businessVehiclePullsTrailer;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Boolean
     */
    public void setBusinessVehiclePullsTrailerInd(final Boolean value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Boolean previousValue = getBusinessVehiclePullsTrailerInd();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setBusinessVehiclePullsTrailerInd(previousValue);
            }
        }
        this.businessVehiclePullsTrailerInd = value;
        getPropertyChangeSupport().firePropertyChange("businessVehiclePullsTrailerInd",
            previousValue, getBusinessVehiclePullsTrailerInd());
    }

    /**
     * Gets the value of businessVehiclePullsTrailerInd.
     * 
     * @return Boolean the value located at businessVehiclePullsTrailerInd
     */
    public Boolean getBusinessVehiclePullsTrailerInd() {
        return this.businessVehiclePullsTrailerInd;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Boolean
     */
    public void setBusinessVehicleUsedForHire(final Boolean value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Boolean previousValue = getBusinessVehicleUsedForHire();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setBusinessVehicleUsedForHire(previousValue);
            }
        }
        this.businessVehicleUsedForHire = value;
        getPropertyChangeSupport().firePropertyChange("businessVehicleUsedForHire", previousValue,
            getBusinessVehicleUsedForHire());
    }

    /**
     * Gets the value of businessVehicleUsedForHire.
     * 
     * @return Boolean the value located at businessVehicleUsedForHire
     */
    public Boolean getBusinessVehicleUsedForHire() {
        return this.businessVehicleUsedForHire;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setCarVanPoolInd(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getCarVanPoolInd();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setCarVanPoolInd(previousValue);
            }
        }
        this.carVanPoolInd = value;
        getPropertyChangeSupport().firePropertyChange("carVanPoolInd", previousValue,
            getCarVanPoolInd());
    }

    /**
     * Gets the value of carVanPoolInd.
     * 
     * @return String the value located at carVanPoolInd
     */
    public String getCarVanPoolInd() {
        return this.carVanPoolInd;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setCatastropheCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getCatastropheCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setCatastropheCode(previousValue);
            }
        }
        this.catastropheCode = value;
        getPropertyChangeSupport().firePropertyChange("catastropheCode", previousValue,
            getCatastropheCode());
    }

    /**
     * Gets the value of catastropheCode.
     * 
     * @return String the value located at catastropheCode
     */
    public String getCatastropheCode() {
        return this.catastropheCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setCededIndicator(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getCededIndicator();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setCededIndicator(previousValue);
            }
        }
        this.cededIndicator = value;
        getPropertyChangeSupport().firePropertyChange("cededIndicator", previousValue,
            getCededIndicator());
    }

    /**
     * Gets the value of cededIndicator.
     * 
     * @return String the value located at cededIndicator
     */
    public String getCededIndicator() {
        return this.cededIndicator;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setClassAssignmentMethodCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getClassAssignmentMethodCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setClassAssignmentMethodCode(previousValue);
            }
        }
        this.classAssignmentMethodCode = value;
        getPropertyChangeSupport().firePropertyChange("classAssignmentMethodCode", previousValue,
            getClassAssignmentMethodCode());
    }

    /**
     * Gets the value of classAssignmentMethodCode.
     * 
     * @return String the value located at classAssignmentMethodCode
     */
    public String getClassAssignmentMethodCode() {
        return this.classAssignmentMethodCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setCollisionClassCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getCollisionClassCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setCollisionClassCode(previousValue);
            }
        }
        this.collisionClassCode = value;
        getPropertyChangeSupport().firePropertyChange("collisionClassCode", previousValue,
            getCollisionClassCode());
    }

    /**
     * Gets the value of collisionClassCode.
     * 
     * @return String the value located at collisionClassCode
     */
    public String getCollisionClassCode() {
        return this.collisionClassCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setComments(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getComments();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setComments(previousValue);
            }
        }
        this.comments = value;
        getPropertyChangeSupport().firePropertyChange("comments", previousValue, getComments());
    }

    /**
     * Gets the value of comments.
     * 
     * @return String the value located at comments
     */
    public String getComments() {
        return this.comments;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type java.math.BigDecimal
     */
    public void setCommercialDriverRatingFactor(final java.math.BigDecimal value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final java.math.BigDecimal previousValue = getCommercialDriverRatingFactor();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setCommercialDriverRatingFactor(previousValue);
            }
        }
        this.commercialDriverRatingFactor = value;
        getPropertyChangeSupport().firePropertyChange("commercialDriverRatingFactor",
            previousValue, getCommercialDriverRatingFactor());
    }

    /**
     * Gets the value of commercialDriverRatingFactor.
     * 
     * @return java.math.BigDecimal the value located at commercialDriverRatingFactor
     */
    public java.math.BigDecimal getCommercialDriverRatingFactor() {
        return this.commercialDriverRatingFactor;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setCommuteSurchargeState(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getCommuteSurchargeState();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setCommuteSurchargeState(previousValue);
            }
        }
        this.commuteSurchargeState = value;
        getPropertyChangeSupport().firePropertyChange("commuteSurchargeState", previousValue,
            getCommuteSurchargeState());
    }

    /**
     * Gets the value of commuteSurchargeState.
     * 
     * @return String the value located at commuteSurchargeState
     */
    public String getCommuteSurchargeState() {
        return this.commuteSurchargeState;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setCommuteSurchargeStateCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getCommuteSurchargeStateCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setCommuteSurchargeStateCode(previousValue);
            }
        }
        this.commuteSurchargeStateCode = value;
        getPropertyChangeSupport().firePropertyChange("commuteSurchargeStateCode", previousValue,
            getCommuteSurchargeStateCode());
    }

    /**
     * Gets the value of commuteSurchargeStateCode.
     * 
     * @return String the value located at commuteSurchargeStateCode
     */
    public String getCommuteSurchargeStateCode() {
        return this.commuteSurchargeStateCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type java.math.BigDecimal
     */
    public void setCostNewAmount(final java.math.BigDecimal value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final java.math.BigDecimal previousValue = getCostNewAmount();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setCostNewAmount(previousValue);
            }
        }
        this.costNewAmount = value;
        getPropertyChangeSupport().firePropertyChange("costNewAmount", previousValue,
            getCostNewAmount());
    }

    /**
     * Gets the value of costNewAmount.
     * 
     * @return java.math.BigDecimal the value located at costNewAmount
     */
    public java.math.BigDecimal getCostNewAmount() {
        return this.costNewAmount;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Boolean
     */
    public void setCostNewCustomizationsIndicator(final Boolean value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Boolean previousValue = getCostNewCustomizationsIndicator();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setCostNewCustomizationsIndicator(previousValue);
            }
        }
        this.costNewCustomizationsIndicator = value;
        getPropertyChangeSupport().firePropertyChange("costNewCustomizationsIndicator",
            previousValue, getCostNewCustomizationsIndicator());
    }

    /**
     * Gets the value of costNewCustomizationsIndicator.
     * 
     * @return Boolean the value located at costNewCustomizationsIndicator
     */
    public Boolean getCostNewCustomizationsIndicator() {
        return this.costNewCustomizationsIndicator;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type CoverageRestriction[]
     */
    public void setCoverageRestrictions(final Object[] value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Object[] previousValue = getCoverageRestrictions();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setCoverageRestrictions(previousValue);
            }
        }
        if (this.coverageRestrictions != null && value == null) {
            if (this.coverageRestrictions.size() >= 0) {
                this.coverageRestrictions.clear(); // to help the garbage collector do it's job
                                                   // easier.
            }
            this.coverageRestrictions = null;
        } else {
            if (this.coverageRestrictions == null) {
                this.coverageRestrictions = new java.util.ArrayList(value.length);
            }
            if (this.coverageRestrictions.size() > 0) {
                this.coverageRestrictions.clear(); // reset/clear current list, we don't want to add
            }
            this.coverageRestrictions.addAll(Arrays.asList(value));
        }
        getPropertyChangeSupport().firePropertyChange("coverageRestrictions", previousValue,
            getCoverageRestrictions());
    }

    /**
     * Sets the value of an array element. Takes no action if read only.
     * 
     * @param index the index into the array
     * @param value the value of type CoverageRestriction[] that will be put into the array
     */
    public void setCoverageRestrictions(final int index, final Object value) {

        if (checkReadOnly()) {
            return;
        }

        final Object[] previousValue = getCoverageRestrictions();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setCoverageRestrictions(index, getCoverageRestrictions(index));
            }
        }
        if (this.coverageRestrictions == null) {
            this.coverageRestrictions = new java.util.ArrayList(index + 1);
        } else if (this.coverageRestrictions.size() < index + 1) {
            this.coverageRestrictions = resize(this.coverageRestrictions, index + 1);
        }
        this.coverageRestrictions.set(index, value);
        getPropertyChangeSupport().firePropertyChange("coverageRestrictions", previousValue,
            getCoverageRestrictions());
    }

    /**
     * Adds an element to an array list the value. Takes no action if read only.
     * 
     * @param value sets value of type CoverageRestriction
     */
    public void addCoverageRestrictions(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        final Object[] previousValue = getCoverageRestrictions();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            }
        }
        if (this.coverageRestrictions == null) {
            this.coverageRestrictions = new java.util.ArrayList(1);
        }
        this.coverageRestrictions.add(value);
        getPropertyChangeSupport().firePropertyChange("coverageRestrictions", previousValue,
            getCoverageRestrictions());
    }

    /**
     * Removes the value. Takes no action if read only
     * 
     * @param value of type CoverageRestriction
     */
    public void removeCoverageRestrictions(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            }
        }
        if (this.coverageRestrictions != null && value != null) {
            this.coverageRestrictions.remove(value);
        }
        getPropertyChangeSupport().firePropertyChange("coverageRestrictions", value, null);
    }

    /**
     * Gets the value of coverageRestrictions.
     * 
     * @return CoverageRestriction[] as an array. Never returns null.
     */
    public Object[] getCoverageRestrictions() {
        if (this.coverageRestrictions == null) {
            this.coverageRestrictions = new java.util.ArrayList();
        }
        return coverageRestrictions.toArray(new Object[this.coverageRestrictions.size()]);
    }

    /**
     * Gets a value from an array.
     * 
     * @param index location in the array to retrieve from}
     * @return CoverageRestriction the value located at location index in coverageRestrictions
     *         Returns null if the array is empty or the index is out of bounds
     */
    public Object getCoverageRestrictions(final int index) {
        if (coverageRestrictions == null || coverageRestrictions.size() < index + 1) {
            return null;
        }
        return coverageRestrictions.get(index);
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type CoverageRestrictionIntegration[]
     */
    public void setCoverageRestrictionsIntegration(final Object[] value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Object[] previousValue = getCoverageRestrictionsIntegration();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setCoverageRestrictionsIntegration(previousValue);
            }
        }
        if (this.coverageRestrictions != null && value == null) {
            if (this.coverageRestrictions.size() >= 0) {
                this.coverageRestrictions.clear(); // to help the garbage collector do it's job
                                                   // easier.
            }
            this.coverageRestrictions = null;
        } else {
            if (this.coverageRestrictions == null) {
                this.coverageRestrictions = new java.util.ArrayList(value.length);
            }
            if (this.coverageRestrictions.size() > 0) {
                this.coverageRestrictions.clear(); // reset/clear current list, we don't want to add
            }
            this.coverageRestrictions.addAll(Arrays.asList(value));
        }
        getPropertyChangeSupport().firePropertyChange("coverageRestrictions", previousValue,
            getCoverageRestrictionsIntegration());
    }

    /**
     * Sets the value of an array element. Takes no action if read only.
     * 
     * @param index the index into the array
     * @param value the value of type CoverageRestrictionIntegration[] that will be put into the
     *        array
     */
    public void setCoverageRestrictionsIntegration(final int index, final Object value) {

        if (checkReadOnly()) {
            return;
        }

        final Object[] previousValue = getCoverageRestrictionsIntegration();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setCoverageRestrictionsIntegration(index,
                    getCoverageRestrictionsIntegration(index));
            }
        }
        if (this.coverageRestrictions == null) {
            this.coverageRestrictions = new java.util.ArrayList(index + 1);
        } else if (this.coverageRestrictions.size() < index + 1) {
            this.coverageRestrictions = resize(this.coverageRestrictions, index + 1);
        }
        this.coverageRestrictions.set(index, value);
        getPropertyChangeSupport().firePropertyChange("coverageRestrictions", previousValue,
            getCoverageRestrictionsIntegration());
    }

    /**
     * Adds an element to an array list the value. Takes no action if read only.
     * 
     * @param value sets value of type CoverageRestrictionIntegration
     */
    public void addCoverageRestrictionsIntegration(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        final Object[] previousValue = getCoverageRestrictionsIntegration();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            }
        }
        if (this.coverageRestrictions == null) {
            this.coverageRestrictions = new java.util.ArrayList(1);
        }
        this.coverageRestrictions.add(value);
        getPropertyChangeSupport().firePropertyChange("coverageRestrictions", previousValue,
            getCoverageRestrictionsIntegration());
    }

    /**
     * Removes the value. Takes no action if read only
     * 
     * @param value of type CoverageRestrictionIntegration
     */
    public void removeCoverageRestrictionsIntegration(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            }
        }
        if (this.coverageRestrictions != null && value != null) {
            this.coverageRestrictions.remove(value);
        }
        getPropertyChangeSupport().firePropertyChange("coverageRestrictions", value, null);
    }

    /**
     * Gets the value of coverageRestrictions.
     * 
     * @return CoverageRestrictionIntegration[] as an array. Never returns null.
     */
    public Object[] getCoverageRestrictionsIntegration() {
        if (this.coverageRestrictions == null) {
            this.coverageRestrictions = new java.util.ArrayList();
        }
        return coverageRestrictions.toArray(new Object[this.coverageRestrictions.size()]);
    }

    /**
     * Gets a value from an array.
     * 
     * @param index location in the array to retrieve from}
     * @return CoverageRestrictionIntegration the value located at location index in
     *         coverageRestrictions Returns null if the array is empty or the index is out of bounds
     */
    public Object getCoverageRestrictionsIntegration(final int index) {
        if (coverageRestrictions == null || coverageRestrictions.size() < index + 1) {
            return null;
        }
        return coverageRestrictions.get(index);
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Coverage[]
     */
    public void setCoverages(final Object[] value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Object[] previousValue = getCoverages();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setCoverages(previousValue);
            }
        }
        if (this.coverages != null && value == null) {
            if (this.coverages.size() >= 0) {
                this.coverages.clear(); // to help the garbage collector do it's job easier.
            }
            this.coverages = null;
        } else {
            if (this.coverages == null) {
                this.coverages = new java.util.ArrayList(value.length);
            }
            if (this.coverages.size() > 0) {
                this.coverages.clear(); // reset/clear current list, we don't want to add
            }
            this.coverages.addAll(Arrays.asList(value));
        }
        getPropertyChangeSupport().firePropertyChange("coverages", previousValue, getCoverages());
    }

    /**
     * Sets the value of an array element. Takes no action if read only.
     * 
     * @param index the index into the array
     * @param value the value of type Coverage[] that will be put into the array
     */
    public void setCoverages(final int index, final Object value) {

        if (checkReadOnly()) {
            return;
        }

        final Object[] previousValue = getCoverages();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setCoverages(index, getCoverages(index));
            }
        }
        if (this.coverages == null) {
            this.coverages = new java.util.ArrayList(index + 1);
        } else if (this.coverages.size() < index + 1) {
            this.coverages = resize(this.coverages, index + 1);
        }
        this.coverages.set(index, value);
        getPropertyChangeSupport().firePropertyChange("coverages", previousValue, getCoverages());
    }

    /**
     * Adds an element to an array list the value. Takes no action if read only.
     * 
     * @param value sets value of type Coverage
     */
    public void addCoverages(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        final Object[] previousValue = getCoverages();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            }
        }
        if (this.coverages == null) {
            this.coverages = new java.util.ArrayList(1);
        }
        this.coverages.add(value);
        getPropertyChangeSupport().firePropertyChange("coverages", previousValue, getCoverages());
    }

    /**
     * Removes the value. Takes no action if read only
     * 
     * @param value of type Coverage
     */
    public void removeCoverages(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            }
        }
        if (this.coverages != null && value != null) {
            this.coverages.remove(value);
        }
        getPropertyChangeSupport().firePropertyChange("coverages", value, null);
    }

    /**
     * Gets the value of coverages.
     * 
     * @return Coverage[] as an array. Never returns null.
     */
    public Object[] getCoverages() {
        if (this.coverages == null) {
            this.coverages = new java.util.ArrayList();
        }
        return coverages.toArray(new Object[this.coverages.size()]);
    }

    /**
     * Gets a value from an array.
     * 
     * @param index location in the array to retrieve from}
     * @return Coverage the value located at location index in coverages Returns null if the array
     *         is empty or the index is out of bounds
     */
    public Object getCoverages(final int index) {
        if (coverages == null || coverages.size() < index + 1) {
            return null;
        }
        return coverages.get(index);
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type CoverageIntegration[]
     */
    public void setCoveragesIntegration(final Object[] value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Object[] previousValue = getCoveragesIntegration();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setCoveragesIntegration(previousValue);
            }
        }
        if (this.coverages != null && value == null) {
            if (this.coverages.size() >= 0) {
                this.coverages.clear(); // to help the garbage collector do it's job easier.
            }
            this.coverages = null;
        } else {
            if (this.coverages == null) {
                this.coverages = new java.util.ArrayList(value.length);
            }
            if (this.coverages.size() > 0) {
                this.coverages.clear(); // reset/clear current list, we don't want to add
            }
            this.coverages.addAll(Arrays.asList(value));
        }
        getPropertyChangeSupport().firePropertyChange("coverages", previousValue,
            getCoveragesIntegration());
    }

    /**
     * Sets the value of an array element. Takes no action if read only.
     * 
     * @param index the index into the array
     * @param value the value of type CoverageIntegration[] that will be put into the array
     */
    public void setCoveragesIntegration(final int index, final Object value) {

        if (checkReadOnly()) {
            return;
        }

        final Object[] previousValue = getCoveragesIntegration();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setCoveragesIntegration(index,
                    getCoveragesIntegration(index));
            }
        }
        if (this.coverages == null) {
            this.coverages = new java.util.ArrayList(index + 1);
        } else if (this.coverages.size() < index + 1) {
            this.coverages = resize(this.coverages, index + 1);
        }
        this.coverages.set(index, value);
        getPropertyChangeSupport().firePropertyChange("coverages", previousValue,
            getCoveragesIntegration());
    }

    /**
     * Adds an element to an array list the value. Takes no action if read only.
     * 
     * @param value sets value of type CoverageIntegration
     */
    public void addCoveragesIntegration(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        final Object[] previousValue = getCoveragesIntegration();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            }
        }
        if (this.coverages == null) {
            this.coverages = new java.util.ArrayList(1);
        }
        this.coverages.add(value);
        getPropertyChangeSupport().firePropertyChange("coverages", previousValue,
            getCoveragesIntegration());
    }

    /**
     * Removes the value. Takes no action if read only
     * 
     * @param value of type CoverageIntegration
     */
    public void removeCoveragesIntegration(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            }
        }
        if (this.coverages != null && value != null) {
            this.coverages.remove(value);
        }
        getPropertyChangeSupport().firePropertyChange("coverages", value, null);
    }

    /**
     * Gets the value of coverages.
     * 
     * @return CoverageIntegration[] as an array. Never returns null.
     */
    public Object[] getCoveragesIntegration() {
        if (this.coverages == null) {
            this.coverages = new java.util.ArrayList();
        }
        return coverages.toArray(new Object[this.coverages.size()]);
    }

    /**
     * Gets a value from an array.
     * 
     * @param index location in the array to retrieve from}
     * @return CoverageIntegration the value located at location index in coverages Returns null if
     *         the array is empty or the index is out of bounds
     */
    public Object getCoveragesIntegration(final int index) {
        if (coverages == null || coverages.size() < index + 1) {
            return null;
        }
        return coverages.get(index);
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type java.math.BigDecimal
     */
    public void setCurrentOdometerAmount(final java.math.BigDecimal value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final java.math.BigDecimal previousValue = getCurrentOdometerAmount();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setCurrentOdometerAmount(previousValue);
            }
        }
        this.currentOdometerAmount = value;
        getPropertyChangeSupport().firePropertyChange("currentOdometerAmount", previousValue,
            getCurrentOdometerAmount());
    }

    /**
     * Gets the value of currentOdometerAmount.
     * 
     * @return java.math.BigDecimal the value located at currentOdometerAmount
     */
    public java.math.BigDecimal getCurrentOdometerAmount() {
        return this.currentOdometerAmount;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Date
     */
    public void setCurrentOdometerDate(final Date value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Date previousValue = getCurrentOdometerDate();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setCurrentOdometerDate(previousValue);
            }
        }
        this.currentOdometerDate = value;
        getPropertyChangeSupport().firePropertyChange("currentOdometerDate", previousValue,
            getCurrentOdometerDate());
    }

    /**
     * Gets the value of currentOdometerDate.
     * 
     * @return Date the value located at currentOdometerDate
     */
    public Date getCurrentOdometerDate() {
        return this.currentOdometerDate;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type java.math.BigDecimal
     */
    public void setCustomizationAmount(final java.math.BigDecimal value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final java.math.BigDecimal previousValue = getCustomizationAmount();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setCustomizationAmount(previousValue);
            }
        }
        this.customizationAmount = value;
        getPropertyChangeSupport().firePropertyChange("customizationAmount", previousValue,
            getCustomizationAmount());
    }

    /**
     * Gets the value of customizationAmount.
     * 
     * @return java.math.BigDecimal the value located at customizationAmount
     */
    public java.math.BigDecimal getCustomizationAmount() {
        return this.customizationAmount;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Integer
     */
    public void setCustomizationsCount(final Integer value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Integer previousValue = getCustomizationsCount();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setCustomizationsCount(previousValue);
            }
        }
        this.customizationsCount = value;
        getPropertyChangeSupport().firePropertyChange("customizationsCount", previousValue,
            getCustomizationsCount());
    }

    /**
     * Gets the value of customizationsCount.
     * 
     * @return Integer the value located at customizationsCount
     */
    public Integer getCustomizationsCount() {
        return this.customizationsCount;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Boolean
     */
    public void setCustomizedIndicator(final Boolean value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Boolean previousValue = getCustomizedIndicator();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setCustomizedIndicator(previousValue);
            }
        }
        this.customizedIndicator = value;
        getPropertyChangeSupport().firePropertyChange("customizedIndicator", previousValue,
            getCustomizedIndicator());
    }

    /**
     * Gets the value of customizedIndicator.
     * 
     * @return Boolean the value located at customizedIndicator
     */
    public Boolean getCustomizedIndicator() {
        return this.customizedIndicator;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setDayTimeRunningLights(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getDayTimeRunningLights();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setDayTimeRunningLights(previousValue);
            }
        }
        this.dayTimeRunningLights = value;
        getPropertyChangeSupport().firePropertyChange("dayTimeRunningLights", previousValue,
            getDayTimeRunningLights());
    }

    /**
     * Gets the value of dayTimeRunningLights.
     * 
     * @return String the value located at dayTimeRunningLights
     */
    public String getDayTimeRunningLights() {
        return this.dayTimeRunningLights;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Integer
     */
    public void setDaysWeekVehDrivenSchool(final Integer value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Integer previousValue = getDaysWeekVehDrivenSchool();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setDaysWeekVehDrivenSchool(previousValue);
            }
        }
        this.daysWeekVehDrivenSchool = value;
        getPropertyChangeSupport().firePropertyChange("daysWeekVehDrivenSchool", previousValue,
            getDaysWeekVehDrivenSchool());
    }

    /**
     * Gets the value of daysWeekVehDrivenSchool.
     * 
     * @return Integer the value located at daysWeekVehDrivenSchool
     */
    public Integer getDaysWeekVehDrivenSchool() {
        return this.daysWeekVehDrivenSchool;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Integer
     */
    public void setDaysWeekVehDrivenWork(final Integer value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Integer previousValue = getDaysWeekVehDrivenWork();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setDaysWeekVehDrivenWork(previousValue);
            }
        }
        this.daysWeekVehDrivenWork = value;
        getPropertyChangeSupport().firePropertyChange("daysWeekVehDrivenWork", previousValue,
            getDaysWeekVehDrivenWork());
    }

    /**
     * Gets the value of daysWeekVehDrivenWork.
     * 
     * @return Integer the value located at daysWeekVehDrivenWork
     */
    public Integer getDaysWeekVehDrivenWork() {
        return this.daysWeekVehDrivenWork;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Boolean
     */
    public void setDaytimeRunningLightsIndicator(final Boolean value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Boolean previousValue = getDaytimeRunningLightsIndicator();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setDaytimeRunningLightsIndicator(previousValue);
            }
        }
        this.daytimeRunningLightsIndicator = value;
        getPropertyChangeSupport().firePropertyChange("daytimeRunningLightsIndicator",
            previousValue, getDaytimeRunningLightsIndicator());
    }

    /**
     * Gets the value of daytimeRunningLightsIndicator.
     * 
     * @return Boolean the value located at daytimeRunningLightsIndicator
     */
    public Boolean getDaytimeRunningLightsIndicator() {
        return this.daytimeRunningLightsIndicator;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setDecode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getDecode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setDecode(previousValue);
            }
        }
        this.decode = value;
        getPropertyChangeSupport().firePropertyChange("decode", previousValue, getDecode());
    }

    /**
     * Gets the value of decode.
     * 
     * @return String the value located at decode
     */
    public String getDecode() {
        return this.decode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type BusinessOwner
     */
    public void setDeletedBusinessOwner(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Object previousValue = getDeletedBusinessOwner();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setDeletedBusinessOwner(previousValue);
            }
        }
        this.deletedBusinessOwnerIntegration = value;
        getPropertyChangeSupport().firePropertyChange("deletedBusinessOwnerIntegration",
            previousValue, getDeletedBusinessOwner());
    }

    /**
     * Gets the value of deletedBusinessOwnerIntegration.
     * 
     * @return BusinessOwner the value located at deletedBusinessOwnerIntegration
     */
    public Object getDeletedBusinessOwner() {
        return this.deletedBusinessOwnerIntegration;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type BusinessOwnerIntegration
     */
    public void setDeletedBusinessOwnerIntegration(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Object previousValue = getDeletedBusinessOwnerIntegration();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setDeletedBusinessOwnerIntegration(previousValue);
            }
        }
        this.deletedBusinessOwnerIntegration = value;
        getPropertyChangeSupport().firePropertyChange("deletedBusinessOwnerIntegration",
            previousValue, getDeletedBusinessOwnerIntegration());
    }

    /**
     * Gets the value of deletedBusinessOwnerIntegration.
     * 
     * @return BusinessOwnerIntegration the value located at deletedBusinessOwnerIntegration
     */
    public Object getDeletedBusinessOwnerIntegration() {
        return this.deletedBusinessOwnerIntegration;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Address
     */
    public void setDeletedGaragedAddress(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Object previousValue = getDeletedGaragedAddress();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setDeletedGaragedAddress(previousValue);
            }
        }
        this.deletedGaragedAddressIntegration = value;
        getPropertyChangeSupport().firePropertyChange("deletedGaragedAddressIntegration",
            previousValue, getDeletedGaragedAddress());
    }

    /**
     * Gets the value of deletedGaragedAddressIntegration.
     * 
     * @return Address the value located at deletedGaragedAddressIntegration
     */
    public Object getDeletedGaragedAddress() {
        return this.deletedGaragedAddressIntegration;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type AddressIntegration
     */
    public void setDeletedGaragedAddressIntegration(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Object previousValue = getDeletedGaragedAddressIntegration();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setDeletedGaragedAddressIntegration(previousValue);
            }
        }
        this.deletedGaragedAddressIntegration = value;
        getPropertyChangeSupport().firePropertyChange("deletedGaragedAddressIntegration",
            previousValue, getDeletedGaragedAddressIntegration());
    }

    /**
     * Gets the value of deletedGaragedAddressIntegration.
     * 
     * @return AddressIntegration the value located at deletedGaragedAddressIntegration
     */
    public Object getDeletedGaragedAddressIntegration() {
        return this.deletedGaragedAddressIntegration;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Address[]
     */
    public void setDeletedGaragedAddresses(final Object[] value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Object[] previousValue = getDeletedGaragedAddresses();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setDeletedGaragedAddresses(previousValue);
            }
        }
        if (this.deletedGaragedAddresses != null && value == null) {
            if (this.deletedGaragedAddresses.size() >= 0) {
                this.deletedGaragedAddresses.clear(); // to help the garbage collector do it's job
                                                      // easier.
            }
            this.deletedGaragedAddresses = null;
        } else {
            if (this.deletedGaragedAddresses == null) {
                this.deletedGaragedAddresses = new java.util.ArrayList(value.length);
            }
            if (this.deletedGaragedAddresses.size() > 0) {
                this.deletedGaragedAddresses.clear(); // reset/clear current list, we don't want to
                                                      // add
            }
            this.deletedGaragedAddresses.addAll(Arrays.asList(value));
        }
        getPropertyChangeSupport().firePropertyChange("deletedGaragedAddresses", previousValue,
            getDeletedGaragedAddresses());
    }

    /**
     * Sets the value of an array element. Takes no action if read only.
     * 
     * @param index the index into the array
     * @param value the value of type Address[] that will be put into the array
     */
    public void setDeletedGaragedAddresses(final int index, final Object value) {

        if (checkReadOnly()) {
            return;
        }

        final Object[] previousValue = getDeletedGaragedAddresses();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setDeletedGaragedAddresses(index, getDeletedGaragedAddresses(index));
            }
        }
        if (this.deletedGaragedAddresses == null) {
            this.deletedGaragedAddresses = new java.util.ArrayList(index + 1);
        } else if (this.deletedGaragedAddresses.size() < index + 1) {
            this.deletedGaragedAddresses = resize(this.deletedGaragedAddresses, index + 1);
        }
        this.deletedGaragedAddresses.set(index, value);
        getPropertyChangeSupport().firePropertyChange("deletedGaragedAddresses", previousValue,
            getDeletedGaragedAddresses());
    }

    /**
     * Adds an element to an array list the value. Takes no action if read only.
     * 
     * @param value sets value of type Address
     */
    public void addDeletedGaragedAddresses(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        final Object[] previousValue = getDeletedGaragedAddresses();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            }
        }
        if (this.deletedGaragedAddresses == null) {
            this.deletedGaragedAddresses = new java.util.ArrayList(1);
        }
        this.deletedGaragedAddresses.add(value);
        getPropertyChangeSupport().firePropertyChange("deletedGaragedAddresses", previousValue,
            getDeletedGaragedAddresses());
    }

    /**
     * Removes the value. Takes no action if read only
     * 
     * @param value of type Address
     */
    public void removeDeletedGaragedAddresses(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            }
        }
        if (this.deletedGaragedAddresses != null && value != null) {
            this.deletedGaragedAddresses.remove(value);
        }
        getPropertyChangeSupport().firePropertyChange("deletedGaragedAddresses", value, null);
    }

    /**
     * Gets the value of deletedGaragedAddresses.
     * 
     * @return Address[] as an array. Never returns null.
     */
    public Object[] getDeletedGaragedAddresses() {
        if (this.deletedGaragedAddresses == null) {
            this.deletedGaragedAddresses = new java.util.ArrayList();
        }
        return deletedGaragedAddresses.toArray(new Object[this.deletedGaragedAddresses.size()]);
    }

    /**
     * Gets a value from an array.
     * 
     * @param index location in the array to retrieve from}
     * @return Address the value located at location index in deletedGaragedAddresses Returns null
     *         if the array is empty or the index is out of bounds
     */
    public Object getDeletedGaragedAddresses(final int index) {
        if (deletedGaragedAddresses == null || deletedGaragedAddresses.size() < index + 1) {
            return null;
        }
        return deletedGaragedAddresses.get(index);
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type AddressIntegration[]
     */
    public void setDeletedGaragedAddressesIntegration(final Object[] value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Object[] previousValue = getDeletedGaragedAddressesIntegration();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setDeletedGaragedAddressesIntegration(previousValue);
            }
        }
        if (this.deletedGaragedAddresses != null && value == null) {
            if (this.deletedGaragedAddresses.size() >= 0) {
                this.deletedGaragedAddresses.clear(); // to help the garbage collector do it's job
                                                      // easier.
            }
            this.deletedGaragedAddresses = null;
        } else {
            if (this.deletedGaragedAddresses == null) {
                this.deletedGaragedAddresses = new java.util.ArrayList(value.length);
            }
            if (this.deletedGaragedAddresses.size() > 0) {
                this.deletedGaragedAddresses.clear(); // reset/clear current list, we don't want to
                                                      // add
            }
            this.deletedGaragedAddresses.addAll(Arrays.asList(value));
        }
        getPropertyChangeSupport().firePropertyChange("deletedGaragedAddresses", previousValue,
            getDeletedGaragedAddressesIntegration());
    }

    /**
     * Sets the value of an array element. Takes no action if read only.
     * 
     * @param index the index into the array
     * @param value the value of type AddressIntegration[] that will be put into the array
     */
    public void setDeletedGaragedAddressesIntegration(final int index, final Object value) {

        if (checkReadOnly()) {
            return;
        }

        final Object[] previousValue = getDeletedGaragedAddressesIntegration();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setDeletedGaragedAddressesIntegration(index,
                    getDeletedGaragedAddressesIntegration(index));
            }
        }
        if (this.deletedGaragedAddresses == null) {
            this.deletedGaragedAddresses = new java.util.ArrayList(index + 1);
        } else if (this.deletedGaragedAddresses.size() < index + 1) {
            this.deletedGaragedAddresses = resize(this.deletedGaragedAddresses, index + 1);
        }
        this.deletedGaragedAddresses.set(index, value);
        getPropertyChangeSupport().firePropertyChange("deletedGaragedAddresses", previousValue,
            getDeletedGaragedAddressesIntegration());
    }

    /**
     * Adds an element to an array list the value. Takes no action if read only.
     * 
     * @param value sets value of type AddressIntegration
     */
    public void addDeletedGaragedAddressesIntegration(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        final Object[] previousValue = getDeletedGaragedAddressesIntegration();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            }
        }
        if (this.deletedGaragedAddresses == null) {
            this.deletedGaragedAddresses = new java.util.ArrayList(1);
        }
        this.deletedGaragedAddresses.add(value);
        getPropertyChangeSupport().firePropertyChange("deletedGaragedAddresses", previousValue,
            getDeletedGaragedAddressesIntegration());
    }

    /**
     * Removes the value. Takes no action if read only
     * 
     * @param value of type AddressIntegration
     */
    public void removeDeletedGaragedAddressesIntegration(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            }
        }
        if (this.deletedGaragedAddresses != null && value != null) {
            this.deletedGaragedAddresses.remove(value);
        }
        getPropertyChangeSupport().firePropertyChange("deletedGaragedAddresses", value, null);
    }

    /**
     * Gets the value of deletedGaragedAddresses.
     * 
     * @return AddressIntegration[] as an array. Never returns null.
     */
    public Object[] getDeletedGaragedAddressesIntegration() {
        if (this.deletedGaragedAddresses == null) {
            this.deletedGaragedAddresses = new java.util.ArrayList();
        }
        return deletedGaragedAddresses.toArray(new Object[this.deletedGaragedAddresses.size()]);
    }

    /**
     * Gets a value from an array.
     * 
     * @param index location in the array to retrieve from}
     * @return AddressIntegration the value located at location index in deletedGaragedAddresses
     *         Returns null if the array is empty or the index is out of bounds
     */
    public Object getDeletedGaragedAddressesIntegration(final int index) {
        if (deletedGaragedAddresses == null || deletedGaragedAddresses.size() < index + 1) {
            return null;
        }
        return deletedGaragedAddresses.get(index);
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setDescription(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getDescription();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setDescription(previousValue);
            }
        }
        this.description = value;
        getPropertyChangeSupport().firePropertyChange("description", previousValue,
            getDescription());
    }

    /**
     * Gets the value of description.
     * 
     * @return String the value located at description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Integer
     */
    public void setDriverOwnerNumber1(final Integer value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Integer previousValue = getDriverOwnerNumber1();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setDriverOwnerNumber1(previousValue);
            }
        }
        this.driverOwnerNumber1 = value;
        getPropertyChangeSupport().firePropertyChange("driverOwnerNumber1", previousValue,
            getDriverOwnerNumber1());
    }

    /**
     * Gets the value of driverOwnerNumber1.
     * 
     * @return Integer the value located at driverOwnerNumber1
     */
    public Integer getDriverOwnerNumber1() {
        return this.driverOwnerNumber1;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Integer
     */
    public void setDriverOwnerNumber2(final Integer value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Integer previousValue = getDriverOwnerNumber2();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setDriverOwnerNumber2(previousValue);
            }
        }
        this.driverOwnerNumber2 = value;
        getPropertyChangeSupport().firePropertyChange("driverOwnerNumber2", previousValue,
            getDriverOwnerNumber2());
    }

    /**
     * Gets the value of driverOwnerNumber2.
     * 
     * @return Integer the value located at driverOwnerNumber2
     */
    public Integer getDriverOwnerNumber2() {
        return this.driverOwnerNumber2;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setDriverTrainingApplies(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getDriverTrainingApplies();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setDriverTrainingApplies(previousValue);
            }
        }
        this.driverTrainingApplies = value;
        getPropertyChangeSupport().firePropertyChange("driverTrainingApplies", previousValue,
            getDriverTrainingApplies());
    }

    /**
     * Gets the value of driverTrainingApplies.
     * 
     * @return String the value located at driverTrainingApplies
     */
    public String getDriverTrainingApplies() {
        return this.driverTrainingApplies;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setDriverVehicleClassCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getDriverVehicleClassCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setDriverVehicleClassCode(previousValue);
            }
        }
        this.driverVehicleClassCode = value;
        getPropertyChangeSupport().firePropertyChange("driverVehicleClassCode", previousValue,
            getDriverVehicleClassCode());
    }

    /**
     * Gets the value of driverVehicleClassCode.
     * 
     * @return String the value located at driverVehicleClassCode
     */
    public String getDriverVehicleClassCode() {
        return this.driverVehicleClassCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Integer
     */
    public void setElectronicCustomizationAmount(final Integer value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Integer previousValue = getElectronicCustomizationAmount();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setElectronicCustomizationAmount(previousValue);
            }
        }
        this.electronicCustomizationAmount = value;
        getPropertyChangeSupport().firePropertyChange("electronicCustomizationAmount",
            previousValue, getElectronicCustomizationAmount());
    }

    /**
     * Gets the value of electronicCustomizationAmount.
     * 
     * @return Integer the value located at electronicCustomizationAmount
     */
    public Integer getElectronicCustomizationAmount() {
        return this.electronicCustomizationAmount;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Boolean
     */
    public void setEligibleIndicator(final Boolean value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Boolean previousValue = getEligibleIndicator();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setEligibleIndicator(previousValue);
            }
        }
        this.eligibleIndicator = value;
        getPropertyChangeSupport().firePropertyChange("eligibleIndicator", previousValue,
            getEligibleIndicator());
    }

    /**
     * Gets the value of eligibleIndicator.
     * 
     * @return Boolean the value located at eligibleIndicator
     */
    public Boolean getEligibleIndicator() {
        return this.eligibleIndicator;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setEmployedByGarageIndicator(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getEmployedByGarageIndicator();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setEmployedByGarageIndicator(previousValue);
            }
        }
        this.employedByGarageIndicator = value;
        getPropertyChangeSupport().firePropertyChange("employedByGarageIndicator", previousValue,
            getEmployedByGarageIndicator());
    }

    /**
     * Gets the value of employedByGarageIndicator.
     * 
     * @return String the value located at employedByGarageIndicator
     */
    public String getEmployedByGarageIndicator() {
        return this.employedByGarageIndicator;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setEngineSizeCubicCcCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getEngineSizeCubicCcCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setEngineSizeCubicCcCode(previousValue);
            }
        }
        this.engineSizeCubicCcCode = value;
        getPropertyChangeSupport().firePropertyChange("engineSizeCubicCcCode", previousValue,
            getEngineSizeCubicCcCode());
    }

    /**
     * Gets the value of engineSizeCubicCcCode.
     * 
     * @return String the value located at engineSizeCubicCcCode
     */
    public String getEngineSizeCubicCcCode() {
        return this.engineSizeCubicCcCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Integer
     */
    public void setEstimatedAnnualMileage(final Integer value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Integer previousValue = getEstimatedAnnualMileage();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setEstimatedAnnualMileage(previousValue);
            }
        }
        this.estimatedAnnualMileage = value;
        getPropertyChangeSupport().firePropertyChange("estimatedAnnualMileage", previousValue,
            getEstimatedAnnualMileage());
    }

    /**
     * Gets the value of estimatedAnnualMileage.
     * 
     * @return Integer the value located at estimatedAnnualMileage
     */
    public Integer getEstimatedAnnualMileage() {
        return this.estimatedAnnualMileage;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Boolean
     */
    public void setExcessVehicleIndicator(final Boolean value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Boolean previousValue = getExcessVehicleIndicator();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setExcessVehicleIndicator(previousValue);
            }
        }
        this.excessVehicleIndicator = value;
        getPropertyChangeSupport().firePropertyChange("excessVehicleIndicator", previousValue,
            getExcessVehicleIndicator());
    }

    /**
     * Gets the value of excessVehicleIndicator.
     * 
     * @return Boolean the value located at excessVehicleIndicator
     */
    public Boolean getExcessVehicleIndicator() {
        return this.excessVehicleIndicator;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setExtendedNonOwnerCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getExtendedNonOwnerCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setExtendedNonOwnerCode(previousValue);
            }
        }
        this.extendedNonOwnerCode = value;
        getPropertyChangeSupport().firePropertyChange("extendedNonOwnerCode", previousValue,
            getExtendedNonOwnerCode());
    }

    /**
     * Gets the value of extendedNonOwnerCode.
     * 
     * @return String the value located at extendedNonOwnerCode
     */
    public String getExtendedNonOwnerCode() {
        return this.extendedNonOwnerCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Boolean
     */
    public void setFailedVinIndicator(final Boolean value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Boolean previousValue = getFailedVinIndicator();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setFailedVinIndicator(previousValue);
            }
        }
        this.failedVinIndicator = value;
        getPropertyChangeSupport().firePropertyChange("failedVinIndicator", previousValue,
            getFailedVinIndicator());
    }

    /**
     * Gets the value of failedVinIndicator.
     * 
     * @return Boolean the value located at failedVinIndicator
     */
    public Boolean getFailedVinIndicator() {
        return this.failedVinIndicator;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Boolean
     */
    public void setFemaleRateClassIndicator(final Boolean value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Boolean previousValue = getFemaleRateClassIndicator();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setFemaleRateClassIndicator(previousValue);
            }
        }
        this.femaleRateClassIndicator = value;
        getPropertyChangeSupport().firePropertyChange("femaleRateClassIndicator", previousValue,
            getFemaleRateClassIndicator());
    }

    /**
     * Gets the value of femaleRateClassIndicator.
     * 
     * @return Boolean the value located at femaleRateClassIndicator
     */
    public Boolean getFemaleRateClassIndicator() {
        return this.femaleRateClassIndicator;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setFinalRiskTerritoryCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getFinalRiskTerritoryCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setFinalRiskTerritoryCode(previousValue);
            }
        }
        this.finalRiskTerritoryCode = value;
        getPropertyChangeSupport().firePropertyChange("finalRiskTerritoryCode", previousValue,
            getFinalRiskTerritoryCode());
    }

    /**
     * Gets the value of finalRiskTerritoryCode.
     * 
     * @return String the value located at finalRiskTerritoryCode
     */
    public String getFinalRiskTerritoryCode() {
        return this.finalRiskTerritoryCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Boolean
     */
    public void setFinancedIndicator(final Boolean value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Boolean previousValue = getFinancedIndicator();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setFinancedIndicator(previousValue);
            }
        }
        this.financedIndicator = value;
        getPropertyChangeSupport().firePropertyChange("financedIndicator", previousValue,
            getFinancedIndicator());
    }

    /**
     * Gets the value of financedIndicator.
     * 
     * @return Boolean the value located at financedIndicator
     */
    public Boolean getFinancedIndicator() {
        return this.financedIndicator;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Form[]
     */
    public void setForms(final Object[] value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Object[] previousValue = getForms();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setForms(previousValue);
            }
        }
        if (this.forms != null && value == null) {
            if (this.forms.size() >= 0) {
                this.forms.clear(); // to help the garbage collector do it's job easier.
            }
            this.forms = null;
        } else {
            if (this.forms == null) {
                this.forms = new java.util.ArrayList(value.length);
            }
            if (this.forms.size() > 0) {
                this.forms.clear(); // reset/clear current list, we don't want to add
            }
            this.forms.addAll(Arrays.asList(value));
        }
        getPropertyChangeSupport().firePropertyChange("forms", previousValue, getForms());
    }

    /**
     * Sets the value of an array element. Takes no action if read only.
     * 
     * @param index the index into the array
     * @param value the value of type Form[] that will be put into the array
     */
    public void setForms(final int index, final Object value) {

        if (checkReadOnly()) {
            return;
        }

        final Object[] previousValue = getForms();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setForms(index, getForms(index));
            }
        }
        if (this.forms == null) {
            this.forms = new java.util.ArrayList(index + 1);
        } else if (this.forms.size() < index + 1) {
            this.forms = resize(this.forms, index + 1);
        }
        this.forms.set(index, value);
        getPropertyChangeSupport().firePropertyChange("forms", previousValue, getForms());
    }

    /**
     * Adds an element to an array list the value. Takes no action if read only.
     * 
     * @param value sets value of type Form
     */
    public void addForms(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        final Object[] previousValue = getForms();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            }
        }
        if (this.forms == null) {
            this.forms = new java.util.ArrayList(1);
        }
        this.forms.add(value);
        getPropertyChangeSupport().firePropertyChange("forms", previousValue, getForms());
    }

    /**
     * Removes the value. Takes no action if read only
     * 
     * @param value of type Form
     */
    public void removeForms(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            }
        }
        if (this.forms != null && value != null) {
            this.forms.remove(value);
        }
        getPropertyChangeSupport().firePropertyChange("forms", value, null);
    }

    /**
     * Gets the value of forms.
     * 
     * @return Form[] as an array. Never returns null.
     */
    public Object[] getForms() {
        if (this.forms == null) {
            this.forms = new java.util.ArrayList();
        }
        return forms.toArray(new Object[this.forms.size()]);
    }

    /**
     * Gets a value from an array.
     * 
     * @param index location in the array to retrieve from}
     * @return Form the value located at location index in forms Returns null if the array is empty
     *         or the index is out of bounds
     */
    public Object getForms(final int index) {
        if (forms == null || forms.size() < index + 1) {
            return null;
        }
        return forms.get(index);
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type FormIntegration[]
     */
    public void setFormsIntegration(final Object[] value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Object[] previousValue = getFormsIntegration();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setFormsIntegration(previousValue);
            }
        }
        if (this.forms != null && value == null) {
            if (this.forms.size() >= 0) {
                this.forms.clear(); // to help the garbage collector do it's job easier.
            }
            this.forms = null;
        } else {
            if (this.forms == null) {
                this.forms = new java.util.ArrayList(value.length);
            }
            if (this.forms.size() > 0) {
                this.forms.clear(); // reset/clear current list, we don't want to add
            }
            this.forms.addAll(Arrays.asList(value));
        }
        getPropertyChangeSupport()
            .firePropertyChange("forms", previousValue, getFormsIntegration());
    }

    /**
     * Sets the value of an array element. Takes no action if read only.
     * 
     * @param index the index into the array
     * @param value the value of type FormIntegration[] that will be put into the array
     */
    public void setFormsIntegration(final int index, final Object value) {

        if (checkReadOnly()) {
            return;
        }

        final Object[] previousValue = getFormsIntegration();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setFormsIntegration(index, getFormsIntegration(index));
            }
        }
        if (this.forms == null) {
            this.forms = new java.util.ArrayList(index + 1);
        } else if (this.forms.size() < index + 1) {
            this.forms = resize(this.forms, index + 1);
        }
        this.forms.set(index, value);
        getPropertyChangeSupport()
            .firePropertyChange("forms", previousValue, getFormsIntegration());
    }

    /**
     * Adds an element to an array list the value. Takes no action if read only.
     * 
     * @param value sets value of type FormIntegration
     */
    public void addFormsIntegration(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        final Object[] previousValue = getFormsIntegration();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            }
        }
        if (this.forms == null) {
            this.forms = new java.util.ArrayList(1);
        }
        this.forms.add(value);
        getPropertyChangeSupport()
            .firePropertyChange("forms", previousValue, getFormsIntegration());
    }

    /**
     * Removes the value. Takes no action if read only
     * 
     * @param value of type FormIntegration
     */
    public void removeFormsIntegration(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            }
        }
        if (this.forms != null && value != null) {
            this.forms.remove(value);
        }
        getPropertyChangeSupport().firePropertyChange("forms", value, null);
    }

    /**
     * Gets the value of forms.
     * 
     * @return FormIntegration[] as an array. Never returns null.
     */
    public Object[] getFormsIntegration() {
        if (this.forms == null) {
            this.forms = new java.util.ArrayList();
        }
        return forms.toArray(new Object[this.forms.size()]);
    }

    /**
     * Gets a value from an array.
     * 
     * @param index location in the array to retrieve from}
     * @return FormIntegration the value located at location index in forms Returns null if the
     *         array is empty or the index is out of bounds
     */
    public Object getFormsIntegration(final int index) {
        if (forms == null || forms.size() < index + 1) {
            return null;
        }
        return forms.get(index);
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setGarageCityGNISCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getGarageCityGNISCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setGarageCityGNISCode(previousValue);
            }
        }
        this.garageCityGNISCode = value;
        getPropertyChangeSupport().firePropertyChange("garageCityGNISCode", previousValue,
            getGarageCityGNISCode());
    }

    /**
     * Gets the value of garageCityGNISCode.
     * 
     * @return String the value located at garageCityGNISCode
     */
    public String getGarageCityGNISCode() {
        return this.garageCityGNISCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Address
     */
    public void setGaragedAddress(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Object previousValue = getGaragedAddress();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setGaragedAddress(previousValue);
            }
        }
        this.garagedAddressIntegration = value;
        getPropertyChangeSupport().firePropertyChange("garagedAddressIntegration", previousValue,
            getGaragedAddress());
    }

    /**
     * Gets the value of garagedAddressIntegration.
     * 
     * @return Address the value located at garagedAddressIntegration
     */
    public Object getGaragedAddress() {
        return this.garagedAddressIntegration;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type AddressIntegration
     */
    public void setGaragedAddressIntegration(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Object previousValue = getGaragedAddressIntegration();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setGaragedAddressIntegration(previousValue);
            }
        }
        this.garagedAddressIntegration = value;
        getPropertyChangeSupport().firePropertyChange("garagedAddressIntegration", previousValue,
            getGaragedAddressIntegration());
    }

    /**
     * Gets the value of garagedAddressIntegration.
     * 
     * @return AddressIntegration the value located at garagedAddressIntegration
     */
    public Object getGaragedAddressIntegration() {
        return this.garagedAddressIntegration;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Address
     */
    public void setGaragedGeocodedAddress(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Object previousValue = getGaragedGeocodedAddress();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setGaragedGeocodedAddress(previousValue);
            }
        }
        this.garagedGeocodedAddressIntegration = value;
        getPropertyChangeSupport().firePropertyChange("garagedGeocodedAddressIntegration",
            previousValue, getGaragedGeocodedAddress());
    }

    /**
     * Gets the value of garagedGeocodedAddressIntegration.
     * 
     * @return Address the value located at garagedGeocodedAddressIntegration
     */
    public Object getGaragedGeocodedAddress() {
        return this.garagedGeocodedAddressIntegration;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type AddressIntegration
     */
    public void setGaragedGeocodedAddressIntegration(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Object previousValue = getGaragedGeocodedAddressIntegration();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setGaragedGeocodedAddressIntegration(previousValue);
            }
        }
        this.garagedGeocodedAddressIntegration = value;
        getPropertyChangeSupport().firePropertyChange("garagedGeocodedAddressIntegration",
            previousValue, getGaragedGeocodedAddressIntegration());
    }

    /**
     * Gets the value of garagedGeocodedAddressIntegration.
     * 
     * @return AddressIntegration the value located at garagedGeocodedAddressIntegration
     */
    public Object getGaragedGeocodedAddressIntegration() {
        return this.garagedGeocodedAddressIntegration;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setGeographicCityCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getGeographicCityCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setGeographicCityCode(previousValue);
            }
        }
        this.geographicCityCode = value;
        getPropertyChangeSupport().firePropertyChange("geographicCityCode", previousValue,
            getGeographicCityCode());
    }

    /**
     * Gets the value of geographicCityCode.
     * 
     * @return String the value located at geographicCityCode
     */
    public String getGeographicCityCode() {
        return this.geographicCityCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setGoodDriverCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getGoodDriverCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setGoodDriverCode(previousValue);
            }
        }
        this.goodDriverCode = value;
        getPropertyChangeSupport().firePropertyChange("goodDriverCode", previousValue,
            getGoodDriverCode());
    }

    /**
     * Gets the value of goodDriverCode.
     * 
     * @return String the value located at goodDriverCode
     */
    public String getGoodDriverCode() {
        return this.goodDriverCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setGrossWeight(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getGrossWeight();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setGrossWeight(previousValue);
            }
        }
        this.grossWeight = value;
        getPropertyChangeSupport().firePropertyChange("grossWeight", previousValue,
            getGrossWeight());
    }

    /**
     * Gets the value of grossWeight.
     * 
     * @return String the value located at grossWeight
     */
    public String getGrossWeight() {
        return this.grossWeight;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setHasAntiLockBrakes(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getHasAntiLockBrakes();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setHasAntiLockBrakes(previousValue);
            }
        }
        this.hasAntiLockBrakes = value;
        getPropertyChangeSupport().firePropertyChange("hasAntiLockBrakes", previousValue,
            getHasAntiLockBrakes());
    }

    /**
     * Gets the value of hasAntiLockBrakes.
     * 
     * @return String the value located at hasAntiLockBrakes
     */
    public String getHasAntiLockBrakes() {
        return this.hasAntiLockBrakes;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setHasAutoSeatBelt(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getHasAutoSeatBelt();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setHasAutoSeatBelt(previousValue);
            }
        }
        this.hasAutoSeatBelt = value;
        getPropertyChangeSupport().firePropertyChange("hasAutoSeatBelt", previousValue,
            getHasAutoSeatBelt());
    }

    /**
     * Gets the value of hasAutoSeatBelt.
     * 
     * @return String the value located at hasAutoSeatBelt
     */
    public String getHasAutoSeatBelt() {
        return this.hasAutoSeatBelt;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setHasDriverSideAirBag(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getHasDriverSideAirBag();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setHasDriverSideAirBag(previousValue);
            }
        }
        this.hasDriverSideAirBag = value;
        getPropertyChangeSupport().firePropertyChange("hasDriverSideAirBag", previousValue,
            getHasDriverSideAirBag());
    }

    /**
     * Gets the value of hasDriverSideAirBag.
     * 
     * @return String the value located at hasDriverSideAirBag
     */
    public String getHasDriverSideAirBag() {
        return this.hasDriverSideAirBag;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setHasPassengerAirBag(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getHasPassengerAirBag();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setHasPassengerAirBag(previousValue);
            }
        }
        this.hasPassengerAirBag = value;
        getPropertyChangeSupport().firePropertyChange("hasPassengerAirBag", previousValue,
            getHasPassengerAirBag());
    }

    /**
     * Gets the value of hasPassengerAirBag.
     * 
     * @return String the value located at hasPassengerAirBag
     */
    public String getHasPassengerAirBag() {
        return this.hasPassengerAirBag;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setHighTheftCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getHighTheftCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setHighTheftCode(previousValue);
            }
        }
        this.highTheftCode = value;
        getPropertyChangeSupport().firePropertyChange("highTheftCode", previousValue,
            getHighTheftCode());
    }

    /**
     * Gets the value of highTheftCode.
     * 
     * @return String the value located at highTheftCode
     */
    public String getHighTheftCode() {
        return this.highTheftCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Boolean
     */
    public void setHistoricalVehicleIndicator(final Boolean value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Boolean previousValue = getHistoricalVehicleIndicator();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setHistoricalVehicleIndicator(previousValue);
            }
        }
        this.historicalVehicleIndicator = value;
        getPropertyChangeSupport().firePropertyChange("historicalVehicleIndicator", previousValue,
            getHistoricalVehicleIndicator());
    }

    /**
     * Gets the value of historicalVehicleIndicator.
     * 
     * @return Boolean the value located at historicalVehicleIndicator
     */
    public Boolean getHistoricalVehicleIndicator() {
        return this.historicalVehicleIndicator;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Float
     */
    public void setHouseholdCompositeFactor(final Float value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Float previousValue = getHouseholdCompositeFactor();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setHouseholdCompositeFactor(previousValue);
            }
        }
        this.householdCompositeFactor = value;
        getPropertyChangeSupport().firePropertyChange("householdCompositeFactor", previousValue,
            getHouseholdCompositeFactor());
    }

    /**
     * Gets the value of householdCompositeFactor.
     * 
     * @return Float the value located at householdCompositeFactor
     */
    public Float getHouseholdCompositeFactor() {
        return this.householdCompositeFactor;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Boolean
     */
    public void setHybridInd(final Boolean value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Boolean previousValue = getHybridInd();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setHybridInd(previousValue);
            }
        }
        this.hybridInd = value;
        getPropertyChangeSupport().firePropertyChange("hybridInd", previousValue, getHybridInd());
    }

    /**
     * Gets the value of hybridInd.
     * 
     * @return Boolean the value located at hybridInd
     */
    public Boolean getHybridInd() {
        return this.hybridInd;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setIndividualCorporateOwnershipCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getIndividualCorporateOwnershipCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setIndividualCorporateOwnershipCode(previousValue);
            }
        }
        this.individualCorporateOwnershipCode = value;
        getPropertyChangeSupport().firePropertyChange("individualCorporateOwnershipCode",
            previousValue, getIndividualCorporateOwnershipCode());
    }

    /**
     * Gets the value of individualCorporateOwnershipCode.
     * 
     * @return String the value located at individualCorporateOwnershipCode
     */
    public String getIndividualCorporateOwnershipCode() {
        return this.individualCorporateOwnershipCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Boolean
     */
    public void setInspectionConsent(final Boolean value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Boolean previousValue = getInspectionConsent();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setInspectionConsent(previousValue);
            }
        }
        this.inspectionConsent = value;
        getPropertyChangeSupport().firePropertyChange("inspectionConsent", previousValue,
            getInspectionConsent());
    }

    /**
     * Gets the value of inspectionConsent.
     * 
     * @return Boolean the value located at inspectionConsent
     */
    public Boolean getInspectionConsent() {
        return this.inspectionConsent;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setInspectionRequiredIndicator(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getInspectionRequiredIndicator();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setInspectionRequiredIndicator(previousValue);
            }
        }
        this.inspectionRequiredIndicator = value;
        getPropertyChangeSupport().firePropertyChange("inspectionRequiredIndicator", previousValue,
            getInspectionRequiredIndicator());
    }

    /**
     * Gets the value of inspectionRequiredIndicator.
     * 
     * @return String the value located at inspectionRequiredIndicator
     */
    public String getInspectionRequiredIndicator() {
        return this.inspectionRequiredIndicator;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setInspectionSite1Code(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getInspectionSite1Code();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setInspectionSite1Code(previousValue);
            }
        }
        this.inspectionSite1Code = value;
        getPropertyChangeSupport().firePropertyChange("inspectionSite1Code", previousValue,
            getInspectionSite1Code());
    }

    /**
     * Gets the value of inspectionSite1Code.
     * 
     * @return String the value located at inspectionSite1Code
     */
    public String getInspectionSite1Code() {
        return this.inspectionSite1Code;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setInspectionSite2Code(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getInspectionSite2Code();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setInspectionSite2Code(previousValue);
            }
        }
        this.inspectionSite2Code = value;
        getPropertyChangeSupport().firePropertyChange("inspectionSite2Code", previousValue,
            getInspectionSite2Code());
    }

    /**
     * Gets the value of inspectionSite2Code.
     * 
     * @return String the value located at inspectionSite2Code
     */
    public String getInspectionSite2Code() {
        return this.inspectionSite2Code;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setInspectionStatusCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getInspectionStatusCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setInspectionStatusCode(previousValue);
            }
        }
        this.inspectionStatusCode = value;
        getPropertyChangeSupport().firePropertyChange("inspectionStatusCode", previousValue,
            getInspectionStatusCode());
    }

    /**
     * Gets the value of inspectionStatusCode.
     * 
     * @return String the value located at inspectionStatusCode
     */
    public String getInspectionStatusCode() {
        return this.inspectionStatusCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Date
     */
    public void setInspectionStatusDate(final Date value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Date previousValue = getInspectionStatusDate();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setInspectionStatusDate(previousValue);
            }
        }
        this.inspectionStatusDate = value;
        getPropertyChangeSupport().firePropertyChange("inspectionStatusDate", previousValue,
            getInspectionStatusDate());
    }

    /**
     * Gets the value of inspectionStatusDate.
     * 
     * @return Date the value located at inspectionStatusDate
     */
    public Date getInspectionStatusDate() {
        return this.inspectionStatusDate;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setInspectionStatusReasonCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getInspectionStatusReasonCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setInspectionStatusReasonCode(previousValue);
            }
        }
        this.inspectionStatusReasonCode = value;
        getPropertyChangeSupport().firePropertyChange("inspectionStatusReasonCode", previousValue,
            getInspectionStatusReasonCode());
    }

    /**
     * Gets the value of inspectionStatusReasonCode.
     * 
     * @return String the value located at inspectionStatusReasonCode
     */
    public String getInspectionStatusReasonCode() {
        return this.inspectionStatusReasonCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setInsuranceLineCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getInsuranceLineCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setInsuranceLineCode(previousValue);
            }
        }
        this.insuranceLineCode = value;
        getPropertyChangeSupport().firePropertyChange("insuranceLineCode", previousValue,
            getInsuranceLineCode());
    }

    /**
     * Gets the value of insuranceLineCode.
     * 
     * @return String the value located at insuranceLineCode
     */
    public String getInsuranceLineCode() {
        return this.insuranceLineCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setIsCustomized(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getIsCustomized();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setIsCustomized(previousValue);
            }
        }
        this.isCustomized = value;
        getPropertyChangeSupport().firePropertyChange("isCustomized", previousValue,
            getIsCustomized());
    }

    /**
     * Gets the value of isCustomized.
     * 
     * @return String the value located at isCustomized
     */
    public String getIsCustomized() {
        return this.isCustomized;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Boolean
     */
    public void setIsGaragedAtDifferentLocation(final Boolean value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Boolean previousValue = getIsGaragedAtDifferentLocation();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setIsGaragedAtDifferentLocation(previousValue);
            }
        }
        this.isGaragedAtDifferentLocation = value;
        getPropertyChangeSupport().firePropertyChange("isGaragedAtDifferentLocation",
            previousValue, getIsGaragedAtDifferentLocation());
    }

    /**
     * Gets the value of isGaragedAtDifferentLocation.
     * 
     * @return Boolean the value located at isGaragedAtDifferentLocation
     */
    public Boolean getIsGaragedAtDifferentLocation() {
        return this.isGaragedAtDifferentLocation;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setIsOtherThanStandardRate(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getIsOtherThanStandardRate();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setIsOtherThanStandardRate(previousValue);
            }
        }
        this.isOtherThanStandardRate = value;
        getPropertyChangeSupport().firePropertyChange("isOtherThanStandardRate", previousValue,
            getIsOtherThanStandardRate());
    }

    /**
     * Gets the value of isOtherThanStandardRate.
     * 
     * @return String the value located at isOtherThanStandardRate
     */
    public String getIsOtherThanStandardRate() {
        return this.isOtherThanStandardRate;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setIsUsedForBusiness(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getIsUsedForBusiness();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setIsUsedForBusiness(previousValue);
            }
        }
        this.isUsedForBusiness = value;
        getPropertyChangeSupport().firePropertyChange("isUsedForBusiness", previousValue,
            getIsUsedForBusiness());
    }

    /**
     * Gets the value of isUsedForBusiness.
     * 
     * @return String the value located at isUsedForBusiness
     */
    public String getIsUsedForBusiness() {
        return this.isUsedForBusiness;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setKeptInGarageIndicator(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getKeptInGarageIndicator();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setKeptInGarageIndicator(previousValue);
            }
        }
        this.keptInGarageIndicator = value;
        getPropertyChangeSupport().firePropertyChange("keptInGarageIndicator", previousValue,
            getKeptInGarageIndicator());
    }

    /**
     * Gets the value of keptInGarageIndicator.
     * 
     * @return String the value located at keptInGarageIndicator
     */
    public String getKeptInGarageIndicator() {
        return this.keptInGarageIndicator;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Boolean
     */
    public void setLeasedIndicator(final Boolean value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Boolean previousValue = getLeasedIndicator();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setLeasedIndicator(previousValue);
            }
        }
        this.leasedIndicator = value;
        getPropertyChangeSupport().firePropertyChange("leasedIndicator", previousValue,
            getLeasedIndicator());
    }

    /**
     * Gets the value of leasedIndicator.
     * 
     * @return Boolean the value located at leasedIndicator
     */
    public Boolean getLeasedIndicator() {
        return this.leasedIndicator;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setLegacyMeritCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getLegacyMeritCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setLegacyMeritCode(previousValue);
            }
        }
        this.legacyMeritCode = value;
        getPropertyChangeSupport().firePropertyChange("legacyMeritCode", previousValue,
            getLegacyMeritCode());
    }

    /**
     * Gets the value of legacyMeritCode.
     * 
     * @return String the value located at legacyMeritCode
     */
    public String getLegacyMeritCode() {
        return this.legacyMeritCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setLiabilitySymbolCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getLiabilitySymbolCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setLiabilitySymbolCode(previousValue);
            }
        }
        this.liabilitySymbolCode = value;
        getPropertyChangeSupport().firePropertyChange("liabilitySymbolCode", previousValue,
            getLiabilitySymbolCode());
    }

    /**
     * Gets the value of liabilitySymbolCode.
     * 
     * @return String the value located at liabilitySymbolCode
     */
    public String getLiabilitySymbolCode() {
        return this.liabilitySymbolCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setLiabilitySymbolOverrideCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getLiabilitySymbolOverrideCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setLiabilitySymbolOverrideCode(previousValue);
            }
        }
        this.liabilitySymbolOverrideCode = value;
        getPropertyChangeSupport().firePropertyChange("liabilitySymbolOverrideCode", previousValue,
            getLiabilitySymbolOverrideCode());
    }

    /**
     * Gets the value of liabilitySymbolOverrideCode.
     * 
     * @return String the value located at liabilitySymbolOverrideCode
     */
    public String getLiabilitySymbolOverrideCode() {
        return this.liabilitySymbolOverrideCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Integer
     */
    public void setLienHolderCount(final Integer value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Integer previousValue = getLienHolderCount();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setLienHolderCount(previousValue);
            }
        }
        this.lienHolderCount = value;
        getPropertyChangeSupport().firePropertyChange("lienHolderCount", previousValue,
            getLienHolderCount());
    }

    /**
     * Gets the value of lienHolderCount.
     * 
     * @return Integer the value located at lienHolderCount
     */
    public Integer getLienHolderCount() {
        return this.lienHolderCount;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type BusinessOwner[]
     */
    public void setLogicallyDeletedBusinessOwners(final Object[] value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Object[] previousValue = getLogicallyDeletedBusinessOwners();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setLogicallyDeletedBusinessOwners(previousValue);
            }
        }
        if (this.logicallyDeletedBusinessOwners != null && value == null) {
            if (this.logicallyDeletedBusinessOwners.size() >= 0) {
                this.logicallyDeletedBusinessOwners.clear(); // to help the garbage collector do
                                                             // it's job easier.
            }
            this.logicallyDeletedBusinessOwners = null;
        } else {
            if (this.logicallyDeletedBusinessOwners == null) {
                this.logicallyDeletedBusinessOwners = new java.util.ArrayList(value.length);
            }
            if (this.logicallyDeletedBusinessOwners.size() > 0) {
                this.logicallyDeletedBusinessOwners.clear(); // reset/clear current list, we don't
                                                             // want to add
            }
            this.logicallyDeletedBusinessOwners.addAll(Arrays.asList(value));
        }
        getPropertyChangeSupport().firePropertyChange("logicallyDeletedBusinessOwners",
            previousValue, getLogicallyDeletedBusinessOwners());
    }

    /**
     * Sets the value of an array element. Takes no action if read only.
     * 
     * @param index the index into the array
     * @param value the value of type BusinessOwner[] that will be put into the array
     */
    public void setLogicallyDeletedBusinessOwners(final int index, final Object value) {

        if (checkReadOnly()) {
            return;
        }

        final Object[] previousValue = getLogicallyDeletedBusinessOwners();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setLogicallyDeletedBusinessOwners(index,
                    getLogicallyDeletedBusinessOwners(index));
            }
        }
        if (this.logicallyDeletedBusinessOwners == null) {
            this.logicallyDeletedBusinessOwners = new java.util.ArrayList(index + 1);
        } else if (this.logicallyDeletedBusinessOwners.size() < index + 1) {
            this.logicallyDeletedBusinessOwners =
                resize(this.logicallyDeletedBusinessOwners, index + 1);
        }
        this.logicallyDeletedBusinessOwners.set(index, value);
        getPropertyChangeSupport().firePropertyChange("logicallyDeletedBusinessOwners",
            previousValue, getLogicallyDeletedBusinessOwners());
    }

    /**
     * Adds an element to an array list the value. Takes no action if read only.
     * 
     * @param value sets value of type BusinessOwner
     */
    public void addLogicallyDeletedBusinessOwners(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        final Object[] previousValue = getLogicallyDeletedBusinessOwners();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            }
        }
        if (this.logicallyDeletedBusinessOwners == null) {
            this.logicallyDeletedBusinessOwners = new java.util.ArrayList(1);
        }
        this.logicallyDeletedBusinessOwners.add(value);
        getPropertyChangeSupport().firePropertyChange("logicallyDeletedBusinessOwners",
            previousValue, getLogicallyDeletedBusinessOwners());
    }

    /**
     * Removes the value. Takes no action if read only
     * 
     * @param value of type BusinessOwner
     */
    public void removeLogicallyDeletedBusinessOwners(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            }
        }
        if (this.logicallyDeletedBusinessOwners != null && value != null) {
            this.logicallyDeletedBusinessOwners.remove(value);
        }
        getPropertyChangeSupport()
            .firePropertyChange("logicallyDeletedBusinessOwners", value, null);
    }

    /**
     * Gets the value of logicallyDeletedBusinessOwners.
     * 
     * @return BusinessOwner[] as an array. Never returns null.
     */
    public Object[] getLogicallyDeletedBusinessOwners() {
        if (this.logicallyDeletedBusinessOwners == null) {
            this.logicallyDeletedBusinessOwners = new java.util.ArrayList();
        }
        return logicallyDeletedBusinessOwners
            .toArray(new Object[this.logicallyDeletedBusinessOwners.size()]);
    }

    /**
     * Gets a value from an array.
     * 
     * @param index location in the array to retrieve from}
     * @return BusinessOwner the value located at location index in logicallyDeletedBusinessOwners
     *         Returns null if the array is empty or the index is out of bounds
     */
    public Object getLogicallyDeletedBusinessOwners(final int index) {
        if (logicallyDeletedBusinessOwners == null
            || logicallyDeletedBusinessOwners.size() < index + 1) {
            return null;
        }
        return logicallyDeletedBusinessOwners.get(index);
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type BusinessOwnerIntegration[]
     */
    public void setLogicallyDeletedBusinessOwnersIntegration(final Object[] value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Object[] previousValue = getLogicallyDeletedBusinessOwnersIntegration();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration()
                    .setLogicallyDeletedBusinessOwnersIntegration(previousValue);
            }
        }
        if (this.logicallyDeletedBusinessOwners != null && value == null) {
            if (this.logicallyDeletedBusinessOwners.size() >= 0) {
                this.logicallyDeletedBusinessOwners.clear(); // to help the garbage collector do
                                                             // it's job easier.
            }
            this.logicallyDeletedBusinessOwners = null;
        } else {
            if (this.logicallyDeletedBusinessOwners == null) {
                this.logicallyDeletedBusinessOwners = new java.util.ArrayList(value.length);
            }
            if (this.logicallyDeletedBusinessOwners.size() > 0) {
                this.logicallyDeletedBusinessOwners.clear(); // reset/clear current list, we don't
                                                             // want to add
            }
            this.logicallyDeletedBusinessOwners.addAll(Arrays.asList(value));
        }
        getPropertyChangeSupport().firePropertyChange("logicallyDeletedBusinessOwners",
            previousValue, getLogicallyDeletedBusinessOwnersIntegration());
    }

    /**
     * Sets the value of an array element. Takes no action if read only.
     * 
     * @param index the index into the array
     * @param value the value of type BusinessOwnerIntegration[] that will be put into the array
     */
    public void setLogicallyDeletedBusinessOwnersIntegration(final int index, final Object value) {

        if (checkReadOnly()) {
            return;
        }

        final Object[] previousValue = getLogicallyDeletedBusinessOwnersIntegration();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setLogicallyDeletedBusinessOwnersIntegration(index,
                    getLogicallyDeletedBusinessOwnersIntegration(index));
            }
        }
        if (this.logicallyDeletedBusinessOwners == null) {
            this.logicallyDeletedBusinessOwners = new java.util.ArrayList(index + 1);
        } else if (this.logicallyDeletedBusinessOwners.size() < index + 1) {
            this.logicallyDeletedBusinessOwners =
                resize(this.logicallyDeletedBusinessOwners, index + 1);
        }
        this.logicallyDeletedBusinessOwners.set(index, value);
        getPropertyChangeSupport().firePropertyChange("logicallyDeletedBusinessOwners",
            previousValue, getLogicallyDeletedBusinessOwnersIntegration());
    }

    /**
     * Adds an element to an array list the value. Takes no action if read only.
     * 
     * @param value sets value of type BusinessOwnerIntegration
     */
    public void addLogicallyDeletedBusinessOwnersIntegration(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        final Object[] previousValue = getLogicallyDeletedBusinessOwnersIntegration();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            }
        }
        if (this.logicallyDeletedBusinessOwners == null) {
            this.logicallyDeletedBusinessOwners = new java.util.ArrayList(1);
        }
        this.logicallyDeletedBusinessOwners.add(value);
        getPropertyChangeSupport().firePropertyChange("logicallyDeletedBusinessOwners",
            previousValue, getLogicallyDeletedBusinessOwnersIntegration());
    }

    /**
     * Removes the value. Takes no action if read only
     * 
     * @param value of type BusinessOwnerIntegration
     */
    public void removeLogicallyDeletedBusinessOwnersIntegration(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            }
        }
        if (this.logicallyDeletedBusinessOwners != null && value != null) {
            this.logicallyDeletedBusinessOwners.remove(value);
        }
        getPropertyChangeSupport()
            .firePropertyChange("logicallyDeletedBusinessOwners", value, null);
    }

    /**
     * Gets the value of logicallyDeletedBusinessOwners.
     * 
     * @return BusinessOwnerIntegration[] as an array. Never returns null.
     */
    public Object[] getLogicallyDeletedBusinessOwnersIntegration() {
        if (this.logicallyDeletedBusinessOwners == null) {
            this.logicallyDeletedBusinessOwners = new java.util.ArrayList();
        }
        return logicallyDeletedBusinessOwners
            .toArray(new Object[this.logicallyDeletedBusinessOwners.size()]);
    }

    /**
     * Gets a value from an array.
     * 
     * @param index location in the array to retrieve from}
     * @return BusinessOwnerIntegration the value located at location index in
     *         logicallyDeletedBusinessOwners Returns null if the array is empty or the index is out
     *         of bounds
     */
    public Object getLogicallyDeletedBusinessOwnersIntegration(final int index) {
        if (logicallyDeletedBusinessOwners == null
            || logicallyDeletedBusinessOwners.size() < index + 1) {
            return null;
        }
        return logicallyDeletedBusinessOwners.get(index);
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Date
     */
    public void setLossDate(final Date value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Date previousValue = getLossDate();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setLossDate(previousValue);
            }
        }
        this.lossDate = value;
        getPropertyChangeSupport().firePropertyChange("lossDate", previousValue, getLossDate());
    }

    /**
     * Gets the value of lossDate.
     * 
     * @return Date the value located at lossDate
     */
    public Date getLossDate() {
        return this.lossDate;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Boolean
     */
    public void setManualRateIndicator(final Boolean value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Boolean previousValue = getManualRateIndicator();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setManualRateIndicator(previousValue);
            }
        }
        this.manualRateIndicator = value;
        getPropertyChangeSupport().firePropertyChange("manualRateIndicator", previousValue,
            getManualRateIndicator());
    }

    /**
     * Gets the value of manualRateIndicator.
     * 
     * @return Boolean the value located at manualRateIndicator
     */
    public Boolean getManualRateIndicator() {
        return this.manualRateIndicator;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setMaterialHauledCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getMaterialHauledCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setMaterialHauledCode(previousValue);
            }
        }
        this.materialHauledCode = value;
        getPropertyChangeSupport().firePropertyChange("materialHauledCode", previousValue,
            getMaterialHauledCode());
    }

    /**
     * Gets the value of materialHauledCode.
     * 
     * @return String the value located at materialHauledCode
     */
    public String getMaterialHauledCode() {
        return this.materialHauledCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setMbiGroupCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getMbiGroupCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setMbiGroupCode(previousValue);
            }
        }
        this.mbiGroupCode = value;
        getPropertyChangeSupport().firePropertyChange("mbiGroupCode", previousValue,
            getMbiGroupCode());
    }

    /**
     * Gets the value of mbiGroupCode.
     * 
     * @return String the value located at mbiGroupCode
     */
    public String getMbiGroupCode() {
        return this.mbiGroupCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Date
     */
    public void setMbiOriginalInceptionDate(final Date value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Date previousValue = getMbiOriginalInceptionDate();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setMbiOriginalInceptionDate(previousValue);
            }
        }
        this.mbiOriginalInceptionDate = value;
        getPropertyChangeSupport().firePropertyChange("mbiOriginalInceptionDate", previousValue,
            getMbiOriginalInceptionDate());
    }

    /**
     * Gets the value of mbiOriginalInceptionDate.
     * 
     * @return Date the value located at mbiOriginalInceptionDate
     */
    public Date getMbiOriginalInceptionDate() {
        return this.mbiOriginalInceptionDate;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setMbiRefusalCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getMbiRefusalCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setMbiRefusalCode(previousValue);
            }
        }
        this.mbiRefusalCode = value;
        getPropertyChangeSupport().firePropertyChange("mbiRefusalCode", previousValue,
            getMbiRefusalCode());
    }

    /**
     * Gets the value of mbiRefusalCode.
     * 
     * @return String the value located at mbiRefusalCode
     */
    public String getMbiRefusalCode() {
        return this.mbiRefusalCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setMotorcycleLendingFrequencyCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getMotorcycleLendingFrequencyCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setMotorcycleLendingFrequencyCode(previousValue);
            }
        }
        this.motorcycleLendingFrequencyCode = value;
        getPropertyChangeSupport().firePropertyChange("motorcycleLendingFrequencyCode",
            previousValue, getMotorcycleLendingFrequencyCode());
    }

    /**
     * Gets the value of motorcycleLendingFrequencyCode.
     * 
     * @return String the value located at motorcycleLendingFrequencyCode
     */
    public String getMotorcycleLendingFrequencyCode() {
        return this.motorcycleLendingFrequencyCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setMotorcycleStorageCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getMotorcycleStorageCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setMotorcycleStorageCode(previousValue);
            }
        }
        this.motorcycleStorageCode = value;
        getPropertyChangeSupport().firePropertyChange("motorcycleStorageCode", previousValue,
            getMotorcycleStorageCode());
    }

    /**
     * Gets the value of motorcycleStorageCode.
     * 
     * @return String the value located at motorcycleStorageCode
     */
    public String getMotorcycleStorageCode() {
        return this.motorcycleStorageCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type java.math.BigDecimal
     */
    public void setMsrpAmount(final java.math.BigDecimal value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final java.math.BigDecimal previousValue = getMsrpAmount();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setMsrpAmount(previousValue);
            }
        }
        this.msrpAmount = value;
        getPropertyChangeSupport().firePropertyChange("msrpAmount", previousValue, getMsrpAmount());
    }

    /**
     * Gets the value of msrpAmount.
     * 
     * @return java.math.BigDecimal the value located at msrpAmount
     */
    public java.math.BigDecimal getMsrpAmount() {
        return this.msrpAmount;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setMultiCarOverride(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getMultiCarOverride();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setMultiCarOverride(previousValue);
            }
        }
        this.multiCarOverride = value;
        getPropertyChangeSupport().firePropertyChange("multiCarOverride", previousValue,
            getMultiCarOverride());
    }

    /**
     * Gets the value of multiCarOverride.
     * 
     * @return String the value located at multiCarOverride
     */
    public String getMultiCarOverride() {
        return this.multiCarOverride;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Boolean
     */
    public void setMulticarDiscountIndicator(final Boolean value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Boolean previousValue = getMulticarDiscountIndicator();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setMulticarDiscountIndicator(previousValue);
            }
        }
        this.multicarDiscountIndicator = value;
        getPropertyChangeSupport().firePropertyChange("multicarDiscountIndicator", previousValue,
            getMulticarDiscountIndicator());
    }

    /**
     * Gets the value of multicarDiscountIndicator.
     * 
     * @return Boolean the value located at multicarDiscountIndicator
     */
    public Boolean getMulticarDiscountIndicator() {
        return this.multicarDiscountIndicator;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Integer
     */
    public void setNonElectronicCustomizationAmount(final Integer value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Integer previousValue = getNonElectronicCustomizationAmount();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setNonElectronicCustomizationAmount(previousValue);
            }
        }
        this.nonElectronicCustomizationAmount = value;
        getPropertyChangeSupport().firePropertyChange("nonElectronicCustomizationAmount",
            previousValue, getNonElectronicCustomizationAmount());
    }

    /**
     * Gets the value of nonElectronicCustomizationAmount.
     * 
     * @return Integer the value located at nonElectronicCustomizationAmount
     */
    public Integer getNonElectronicCustomizationAmount() {
        return this.nonElectronicCustomizationAmount;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Integer
     */
    public void setNumberOfInterestedParties(final Integer value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Integer previousValue = getNumberOfInterestedParties();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setNumberOfInterestedParties(previousValue);
            }
        }
        this.numberOfInterestedParties = value;
        getPropertyChangeSupport().firePropertyChange("numberOfInterestedParties", previousValue,
            getNumberOfInterestedParties());
    }

    /**
     * Gets the value of numberOfInterestedParties.
     * 
     * @return Integer the value located at numberOfInterestedParties
     */
    public Integer getNumberOfInterestedParties() {
        return this.numberOfInterestedParties;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Integer
     */
    public void setNumberOfMilesToSchool(final Integer value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Integer previousValue = getNumberOfMilesToSchool();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setNumberOfMilesToSchool(previousValue);
            }
        }
        this.numberOfMilesToSchool = value;
        getPropertyChangeSupport().firePropertyChange("numberOfMilesToSchool", previousValue,
            getNumberOfMilesToSchool());
    }

    /**
     * Gets the value of numberOfMilesToSchool.
     * 
     * @return Integer the value located at numberOfMilesToSchool
     */
    public Integer getNumberOfMilesToSchool() {
        return this.numberOfMilesToSchool;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Integer
     */
    public void setNumberOfMilesToWork(final Integer value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Integer previousValue = getNumberOfMilesToWork();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setNumberOfMilesToWork(previousValue);
            }
        }
        this.numberOfMilesToWork = value;
        getPropertyChangeSupport().firePropertyChange("numberOfMilesToWork", previousValue,
            getNumberOfMilesToWork());
    }

    /**
     * Gets the value of numberOfMilesToWork.
     * 
     * @return Integer the value located at numberOfMilesToWork
     */
    public Integer getNumberOfMilesToWork() {
        return this.numberOfMilesToWork;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Integer
     */
    public void setNumberOfOwners(final Integer value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Integer previousValue = getNumberOfOwners();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setNumberOfOwners(previousValue);
            }
        }
        this.numberOfOwners = value;
        getPropertyChangeSupport().firePropertyChange("numberOfOwners", previousValue,
            getNumberOfOwners());
    }

    /**
     * Gets the value of numberOfOwners.
     * 
     * @return Integer the value located at numberOfOwners
     */
    public Integer getNumberOfOwners() {
        return this.numberOfOwners;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type java.math.BigDecimal
     */
    public void setNumberOfVehicleApcPoints(final java.math.BigDecimal value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final java.math.BigDecimal previousValue = getNumberOfVehicleApcPoints();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setNumberOfVehicleApcPoints(previousValue);
            }
        }
        this.numberOfVehicleApcPoints = value;
        getPropertyChangeSupport().firePropertyChange("numberOfVehicleApcPoints", previousValue,
            getNumberOfVehicleApcPoints());
    }

    /**
     * Gets the value of numberOfVehicleApcPoints.
     * 
     * @return java.math.BigDecimal the value located at numberOfVehicleApcPoints
     */
    public java.math.BigDecimal getNumberOfVehicleApcPoints() {
        return this.numberOfVehicleApcPoints;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setOccurrenceLocation(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getOccurrenceLocation();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setOccurrenceLocation(previousValue);
            }
        }
        this.occurrenceLocation = value;
        getPropertyChangeSupport().firePropertyChange("occurrenceLocation", previousValue,
            getOccurrenceLocation());
    }

    /**
     * Gets the value of occurrenceLocation.
     * 
     * @return String the value located at occurrenceLocation
     */
    public String getOccurrenceLocation() {
        return this.occurrenceLocation;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Operator[]
     */
    public void setOperators(final Object[] value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Object[] previousValue = getOperators();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setOperators(previousValue);
            }
        }
        if (this.operators != null && value == null) {
            if (this.operators.size() >= 0) {
                this.operators.clear(); // to help the garbage collector do it's job easier.
            }
            this.operators = null;
        } else {
            if (this.operators == null) {
                this.operators = new java.util.ArrayList(value.length);
            }
            if (this.operators.size() > 0) {
                this.operators.clear(); // reset/clear current list, we don't want to add
            }
            this.operators.addAll(Arrays.asList(value));
        }
        getPropertyChangeSupport().firePropertyChange("operators", previousValue, getOperators());
    }

    /**
     * Sets the value of an array element. Takes no action if read only.
     * 
     * @param index the index into the array
     * @param value the value of type Operator[] that will be put into the array
     */
    public void setOperators(final int index, final Object value) {

        if (checkReadOnly()) {
            return;
        }

        final Object[] previousValue = getOperators();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setOperators(index, getOperators(index));
            }
        }
        if (this.operators == null) {
            this.operators = new java.util.ArrayList(index + 1);
        } else if (this.operators.size() < index + 1) {
            this.operators = resize(this.operators, index + 1);
        }
        this.operators.set(index, value);
        getPropertyChangeSupport().firePropertyChange("operators", previousValue, getOperators());
    }

    /**
     * Adds an element to an array list the value. Takes no action if read only.
     * 
     * @param value sets value of type Operator
     */
    public void addOperators(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        final Object[] previousValue = getOperators();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            }
        }
        if (this.operators == null) {
            this.operators = new java.util.ArrayList(1);
        }
        this.operators.add(value);
        getPropertyChangeSupport().firePropertyChange("operators", previousValue, getOperators());
    }

    /**
     * Removes the value. Takes no action if read only
     * 
     * @param value of type Operator
     */
    public void removeOperators(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            }
        }
        if (this.operators != null && value != null) {
            this.operators.remove(value);
        }
        getPropertyChangeSupport().firePropertyChange("operators", value, null);
    }

    /**
     * Gets the value of operators.
     * 
     * @return Operator[] as an array. Never returns null.
     */
    public Object[] getOperators() {
        if (this.operators == null) {
            this.operators = new java.util.ArrayList();
        }
        return operators.toArray(new Object[this.operators.size()]);
    }

    /**
     * Gets a value from an array.
     * 
     * @param index location in the array to retrieve from}
     * @return Operator the value located at location index in operators Returns null if the array
     *         is empty or the index is out of bounds
     */
    public Object getOperators(final int index) {
        if (operators == null || operators.size() < index + 1) {
            return null;
        }
        return operators.get(index);
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type OperatorIntegration[]
     */
    public void setOperatorsIntegration(final Object[] value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Object[] previousValue = getOperatorsIntegration();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setOperatorsIntegration(previousValue);
            }
        }
        if (this.operators != null && value == null) {
            if (this.operators.size() >= 0) {
                this.operators.clear(); // to help the garbage collector do it's job easier.
            }
            this.operators = null;
        } else {
            if (this.operators == null) {
                this.operators = new java.util.ArrayList(value.length);
            }
            if (this.operators.size() > 0) {
                this.operators.clear(); // reset/clear current list, we don't want to add
            }
            this.operators.addAll(Arrays.asList(value));
        }
        getPropertyChangeSupport().firePropertyChange("operators", previousValue,
            getOperatorsIntegration());
    }

    /**
     * Sets the value of an array element. Takes no action if read only.
     * 
     * @param index the index into the array
     * @param value the value of type OperatorIntegration[] that will be put into the array
     */
    public void setOperatorsIntegration(final int index, final Object value) {

        if (checkReadOnly()) {
            return;
        }

        final Object[] previousValue = getOperatorsIntegration();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setOperatorsIntegration(index,
                    getOperatorsIntegration(index));
            }
        }
        if (this.operators == null) {
            this.operators = new java.util.ArrayList(index + 1);
        } else if (this.operators.size() < index + 1) {
            this.operators = resize(this.operators, index + 1);
        }
        this.operators.set(index, value);
        getPropertyChangeSupport().firePropertyChange("operators", previousValue,
            getOperatorsIntegration());
    }

    /**
     * Adds an element to an array list the value. Takes no action if read only.
     * 
     * @param value sets value of type OperatorIntegration
     */
    public void addOperatorsIntegration(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        final Object[] previousValue = getOperatorsIntegration();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            }
        }
        if (this.operators == null) {
            this.operators = new java.util.ArrayList(1);
        }
        this.operators.add(value);
        getPropertyChangeSupport().firePropertyChange("operators", previousValue,
            getOperatorsIntegration());
    }

    /**
     * Removes the value. Takes no action if read only
     * 
     * @param value of type OperatorIntegration
     */
    public void removeOperatorsIntegration(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            }
        }
        if (this.operators != null && value != null) {
            this.operators.remove(value);
        }
        getPropertyChangeSupport().firePropertyChange("operators", value, null);
    }

    /**
     * Gets the value of operators.
     * 
     * @return OperatorIntegration[] as an array. Never returns null.
     */
    public Object[] getOperatorsIntegration() {
        if (this.operators == null) {
            this.operators = new java.util.ArrayList();
        }
        return operators.toArray(new Object[this.operators.size()]);
    }

    /**
     * Gets a value from an array.
     * 
     * @param index location in the array to retrieve from}
     * @return OperatorIntegration the value located at location index in operators Returns null if
     *         the array is empty or the index is out of bounds
     */
    public Object getOperatorsIntegration(final int index) {
        if (operators == null || operators.size() < index + 1) {
            return null;
        }
        return operators.get(index);
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Date
     */
    public void setOriginalEffectiveDate(final Date value) {

        if (checkReadOnly()) {
            return;
        }

    }

    /**
     * Gets the value of originalEffectiveDate.
     * 
     * @return Date the value located at originalEffectiveDate
     */
    public Date getOriginalEffectiveDate() {
        return null;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Integer
     */
    public void setOriginalReplacedVehicleUnitNumber(final Integer value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Integer previousValue = getOriginalReplacedVehicleUnitNumber();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setOriginalReplacedVehicleUnitNumber(previousValue);
            }
        }
        this.originalReplacedVehicleUnitNumber = value;
        getPropertyChangeSupport().firePropertyChange("originalReplacedVehicleUnitNumber",
            previousValue, getOriginalReplacedVehicleUnitNumber());
    }

    /**
     * Gets the value of originalReplacedVehicleUnitNumber.
     * 
     * @return Integer the value located at originalReplacedVehicleUnitNumber
     */
    public Integer getOriginalReplacedVehicleUnitNumber() {
        return this.originalReplacedVehicleUnitNumber;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Boolean
     */
    public void setOtherInterestPartyIndicator(final Boolean value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Boolean previousValue = getOtherInterestPartyIndicator();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setOtherInterestPartyIndicator(previousValue);
            }
        }
        this.otherInterestPartyIndicator = value;
        getPropertyChangeSupport().firePropertyChange("otherInterestPartyIndicator", previousValue,
            getOtherInterestPartyIndicator());
    }

    /**
     * Gets the value of otherInterestPartyIndicator.
     * 
     * @return Boolean the value located at otherInterestPartyIndicator
     */
    public Boolean getOtherInterestPartyIndicator() {
        return this.otherInterestPartyIndicator;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setOverMAIPIndicator(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getOverMAIPIndicator();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setOverMAIPIndicator(previousValue);
            }
        }
        this.overMAIPIndicator = value;
        getPropertyChangeSupport().firePropertyChange("overMAIPIndicator", previousValue,
            getOverMAIPIndicator());
    }

    /**
     * Gets the value of overMAIPIndicator.
     * 
     * @return String the value located at overMAIPIndicator
     */
    public String getOverMAIPIndicator() {
        return this.overMAIPIndicator;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Boolean
     */
    public void setOwner1RegisteredNameIndicator(final Boolean value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Boolean previousValue = getOwner1RegisteredNameIndicator();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setOwner1RegisteredNameIndicator(previousValue);
            }
        }
        this.owner1RegisteredNameIndicator = value;
        getPropertyChangeSupport().firePropertyChange("owner1RegisteredNameIndicator",
            previousValue, getOwner1RegisteredNameIndicator());
    }

    /**
     * Gets the value of owner1RegisteredNameIndicator.
     * 
     * @return Boolean the value located at owner1RegisteredNameIndicator
     */
    public Boolean getOwner1RegisteredNameIndicator() {
        return this.owner1RegisteredNameIndicator;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Boolean
     */
    public void setOwner2RegisteredNameIndicator(final Boolean value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Boolean previousValue = getOwner2RegisteredNameIndicator();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setOwner2RegisteredNameIndicator(previousValue);
            }
        }
        this.owner2RegisteredNameIndicator = value;
        getPropertyChangeSupport().firePropertyChange("owner2RegisteredNameIndicator",
            previousValue, getOwner2RegisteredNameIndicator());
    }

    /**
     * Gets the value of owner2RegisteredNameIndicator.
     * 
     * @return Boolean the value located at owner2RegisteredNameIndicator
     */
    public Boolean getOwner2RegisteredNameIndicator() {
        return this.owner2RegisteredNameIndicator;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setPaVehSubtypeCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getPaVehSubtypeCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setPaVehSubtypeCode(previousValue);
            }
        }
        this.paVehSubtypeCode = value;
        getPropertyChangeSupport().firePropertyChange("paVehSubtypeCode", previousValue,
            getPaVehSubtypeCode());
    }

    /**
     * Gets the value of paVehSubtypeCode.
     * 
     * @return String the value located at paVehSubtypeCode
     */
    public String getPaVehSubtypeCode() {
        return this.paVehSubtypeCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setPaVehicleFutureUseCode3(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getPaVehicleFutureUseCode3();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setPaVehicleFutureUseCode3(previousValue);
            }
        }
        this.paVehicleFutureUseCode3 = value;
        getPropertyChangeSupport().firePropertyChange("paVehicleFutureUseCode3", previousValue,
            getPaVehicleFutureUseCode3());
    }

    /**
     * Gets the value of paVehicleFutureUseCode3.
     * 
     * @return String the value located at paVehicleFutureUseCode3
     */
    public String getPaVehicleFutureUseCode3() {
        return this.paVehicleFutureUseCode3;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Date
     */
    public void setPaVehicleFutureUseDate1(final Date value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Date previousValue = getPaVehicleFutureUseDate1();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setPaVehicleFutureUseDate1(previousValue);
            }
        }
        this.paVehicleFutureUseDate1 = value;
        getPropertyChangeSupport().firePropertyChange("paVehicleFutureUseDate1", previousValue,
            getPaVehicleFutureUseDate1());
    }

    /**
     * Gets the value of paVehicleFutureUseDate1.
     * 
     * @return Date the value located at paVehicleFutureUseDate1
     */
    public Date getPaVehicleFutureUseDate1() {
        return this.paVehicleFutureUseDate1;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setPaVehicleFutureUseIndicator5(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getPaVehicleFutureUseIndicator5();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setPaVehicleFutureUseIndicator5(previousValue);
            }
        }
        this.paVehicleFutureUseIndicator5 = value;
        getPropertyChangeSupport().firePropertyChange("paVehicleFutureUseIndicator5",
            previousValue, getPaVehicleFutureUseIndicator5());
    }

    /**
     * Gets the value of paVehicleFutureUseIndicator5.
     * 
     * @return String the value located at paVehicleFutureUseIndicator5
     */
    public String getPaVehicleFutureUseIndicator5() {
        return this.paVehicleFutureUseIndicator5;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setPaVehicleFutureUseIndicator6(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getPaVehicleFutureUseIndicator6();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setPaVehicleFutureUseIndicator6(previousValue);
            }
        }
        this.paVehicleFutureUseIndicator6 = value;
        getPropertyChangeSupport().firePropertyChange("paVehicleFutureUseIndicator6",
            previousValue, getPaVehicleFutureUseIndicator6());
    }

    /**
     * Gets the value of paVehicleFutureUseIndicator6.
     * 
     * @return String the value located at paVehicleFutureUseIndicator6
     */
    public String getPaVehicleFutureUseIndicator6() {
        return this.paVehicleFutureUseIndicator6;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Object
     */
    public void setPaVehicleHistorizationAttributes(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Object previousValue = getPaVehicleHistorizationAttributes();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setPaVehicleHistorizationAttributes(previousValue);
            }
        }
        this.paVehicleHistorizationAttributes = value;
        getPropertyChangeSupport().firePropertyChange("paVehicleHistorizationAttributes",
            previousValue, getPaVehicleHistorizationAttributes());
    }

    /**
     * Gets the value of paVehicleHistorizationAttributes.
     * 
     * @return Object the value located at paVehicleHistorizationAttributes
     */
    public Object getPaVehicleHistorizationAttributes() {
        return this.paVehicleHistorizationAttributes;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setPassiveRestraintCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getPassiveRestraintCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setPassiveRestraintCode(previousValue);
            }
        }
        this.passiveRestraintCode = value;
        getPropertyChangeSupport().firePropertyChange("passiveRestraintCode", previousValue,
            getPassiveRestraintCode());
    }

    /**
     * Gets the value of passiveRestraintCode.
     * 
     * @return String the value located at passiveRestraintCode
     */
    public String getPassiveRestraintCode() {
        return this.passiveRestraintCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type java.math.BigDecimal
     */
    public void setPavePurchaseAmount(final java.math.BigDecimal value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final java.math.BigDecimal previousValue = getPavePurchaseAmount();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setPavePurchaseAmount(previousValue);
            }
        }
        this.pavePurchaseAmount = value;
        getPropertyChangeSupport().firePropertyChange("pavePurchaseAmount", previousValue,
            getPavePurchaseAmount());
    }

    /**
     * Gets the value of pavePurchaseAmount.
     * 
     * @return java.math.BigDecimal the value located at pavePurchaseAmount
     */
    public java.math.BigDecimal getPavePurchaseAmount() {
        return this.pavePurchaseAmount;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setPhysicalVehicleTypeCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getPhysicalVehicleTypeCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setPhysicalVehicleTypeCode(previousValue);
            }
        }
        this.physicalVehicleTypeCode = value;
        getPropertyChangeSupport().firePropertyChange("physicalVehicleTypeCode", previousValue,
            getPhysicalVehicleTypeCode());
    }

    /**
     * Gets the value of physicalVehicleTypeCode.
     * 
     * @return String the value located at physicalVehicleTypeCode
     */
    public String getPhysicalVehicleTypeCode() {
        return this.physicalVehicleTypeCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setPolicyId(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getPolicyId();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setPolicyId(previousValue);
            }
        }
        this.policyId = value;
        getPropertyChangeSupport().firePropertyChange("policyId", previousValue, getPolicyId());
    }

    /**
     * Gets the value of policyId.
     * 
     * @return String the value located at policyId
     */
    public String getPolicyId() {
        return this.policyId;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setPolicySurchargeInd(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getPolicySurchargeInd();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setPolicySurchargeInd(previousValue);
            }
        }
        this.policySurchargeInd = value;
        getPropertyChangeSupport().firePropertyChange("policySurchargeInd", previousValue,
            getPolicySurchargeInd());
    }

    /**
     * Gets the value of policySurchargeInd.
     * 
     * @return String the value located at policySurchargeInd
     */
    public String getPolicySurchargeInd() {
        return this.policySurchargeInd;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type PremiumDiscount[]
     */
    public void setPremiumDiscounts(final Object[] value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Object[] previousValue = getPremiumDiscounts();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setPremiumDiscounts(previousValue);
            }
        }
        if (this.premiumDiscounts != null && value == null) {
            if (this.premiumDiscounts.size() >= 0) {
                this.premiumDiscounts.clear(); // to help the garbage collector do it's job easier.
            }
            this.premiumDiscounts = null;
        } else {
            if (this.premiumDiscounts == null) {
                this.premiumDiscounts = new java.util.ArrayList(value.length);
            }
            if (this.premiumDiscounts.size() > 0) {
                this.premiumDiscounts.clear(); // reset/clear current list, we don't want to add
            }
            this.premiumDiscounts.addAll(Arrays.asList(value));
        }
        getPropertyChangeSupport().firePropertyChange("premiumDiscounts", previousValue,
            getPremiumDiscounts());
    }

    /**
     * Sets the value of an array element. Takes no action if read only.
     * 
     * @param index the index into the array
     * @param value the value of type PremiumDiscount[] that will be put into the array
     */
    public void setPremiumDiscounts(final int index, final Object value) {

        if (checkReadOnly()) {
            return;
        }

        final Object[] previousValue = getPremiumDiscounts();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setPremiumDiscounts(index, getPremiumDiscounts(index));
            }
        }
        if (this.premiumDiscounts == null) {
            this.premiumDiscounts = new java.util.ArrayList(index + 1);
        } else if (this.premiumDiscounts.size() < index + 1) {
            this.premiumDiscounts = resize(this.premiumDiscounts, index + 1);
        }
        this.premiumDiscounts.set(index, value);
        getPropertyChangeSupport().firePropertyChange("premiumDiscounts", previousValue,
            getPremiumDiscounts());
    }

    /**
     * Adds an element to an array list the value. Takes no action if read only.
     * 
     * @param value sets value of type PremiumDiscount
     */
    public void addPremiumDiscounts(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        final Object[] previousValue = getPremiumDiscounts();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            }
        }
        if (this.premiumDiscounts == null) {
            this.premiumDiscounts = new java.util.ArrayList(1);
        }
        this.premiumDiscounts.add(value);
        getPropertyChangeSupport().firePropertyChange("premiumDiscounts", previousValue,
            getPremiumDiscounts());
    }

    /**
     * Removes the value. Takes no action if read only
     * 
     * @param value of type PremiumDiscount
     */
    public void removePremiumDiscounts(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            }
        }
        if (this.premiumDiscounts != null && value != null) {
            this.premiumDiscounts.remove(value);
        }
        getPropertyChangeSupport().firePropertyChange("premiumDiscounts", value, null);
    }

    /**
     * Gets the value of premiumDiscounts.
     * 
     * @return PremiumDiscount[] as an array. Never returns null.
     */
    public Object[] getPremiumDiscounts() {
        if (this.premiumDiscounts == null) {
            this.premiumDiscounts = new java.util.ArrayList();
        }
        return premiumDiscounts.toArray(new Object[this.premiumDiscounts.size()]);
    }

    /**
     * Gets a value from an array.
     * 
     * @param index location in the array to retrieve from}
     * @return PremiumDiscount the value located at location index in premiumDiscounts Returns null
     *         if the array is empty or the index is out of bounds
     */
    public Object getPremiumDiscounts(final int index) {
        if (premiumDiscounts == null || premiumDiscounts.size() < index + 1) {
            return null;
        }
        return premiumDiscounts.get(index);
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type PremiumDiscountIntegration[]
     */
    public void setPremiumDiscountsIntegration(final Object[] value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Object[] previousValue = getPremiumDiscountsIntegration();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setPremiumDiscountsIntegration(previousValue);
            }
        }
        if (this.premiumDiscounts != null && value == null) {
            if (this.premiumDiscounts.size() >= 0) {
                this.premiumDiscounts.clear(); // to help the garbage collector do it's job easier.
            }
            this.premiumDiscounts = null;
        } else {
            if (this.premiumDiscounts == null) {
                this.premiumDiscounts = new java.util.ArrayList(value.length);
            }
            if (this.premiumDiscounts.size() > 0) {
                this.premiumDiscounts.clear(); // reset/clear current list, we don't want to add
            }
            this.premiumDiscounts.addAll(Arrays.asList(value));
        }
        getPropertyChangeSupport().firePropertyChange("premiumDiscounts", previousValue,
            getPremiumDiscountsIntegration());
    }

    /**
     * Sets the value of an array element. Takes no action if read only.
     * 
     * @param index the index into the array
     * @param value the value of type PremiumDiscountIntegration[] that will be put into the array
     */
    public void setPremiumDiscountsIntegration(final int index, final Object value) {

        if (checkReadOnly()) {
            return;
        }

        final Object[] previousValue = getPremiumDiscountsIntegration();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setPremiumDiscountsIntegration(index,
                    getPremiumDiscountsIntegration(index));
            }
        }
        if (this.premiumDiscounts == null) {
            this.premiumDiscounts = new java.util.ArrayList(index + 1);
        } else if (this.premiumDiscounts.size() < index + 1) {
            this.premiumDiscounts = resize(this.premiumDiscounts, index + 1);
        }
        this.premiumDiscounts.set(index, value);
        getPropertyChangeSupport().firePropertyChange("premiumDiscounts", previousValue,
            getPremiumDiscountsIntegration());
    }

    /**
     * Adds an element to an array list the value. Takes no action if read only.
     * 
     * @param value sets value of type PremiumDiscountIntegration
     */
    public void addPremiumDiscountsIntegration(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        final Object[] previousValue = getPremiumDiscountsIntegration();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            }
        }
        if (this.premiumDiscounts == null) {
            this.premiumDiscounts = new java.util.ArrayList(1);
        }
        this.premiumDiscounts.add(value);
        getPropertyChangeSupport().firePropertyChange("premiumDiscounts", previousValue,
            getPremiumDiscountsIntegration());
    }

    /**
     * Removes the value. Takes no action if read only
     * 
     * @param value of type PremiumDiscountIntegration
     */
    public void removePremiumDiscountsIntegration(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            }
        }
        if (this.premiumDiscounts != null && value != null) {
            this.premiumDiscounts.remove(value);
        }
        getPropertyChangeSupport().firePropertyChange("premiumDiscounts", value, null);
    }

    /**
     * Gets the value of premiumDiscounts.
     * 
     * @return PremiumDiscountIntegration[] as an array. Never returns null.
     */
    public Object[] getPremiumDiscountsIntegration() {
        if (this.premiumDiscounts == null) {
            this.premiumDiscounts = new java.util.ArrayList();
        }
        return premiumDiscounts.toArray(new Object[this.premiumDiscounts.size()]);
    }

    /**
     * Gets a value from an array.
     * 
     * @param index location in the array to retrieve from}
     * @return PremiumDiscountIntegration the value located at location index in premiumDiscounts
     *         Returns null if the array is empty or the index is out of bounds
     */
    public Object getPremiumDiscountsIntegration(final int index) {
        if (premiumDiscounts == null || premiumDiscounts.size() < index + 1) {
            return null;
        }
        return premiumDiscounts.get(index);
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setPreviousCityCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getPreviousCityCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setPreviousCityCode(previousValue);
            }
        }
        this.previousCityCode = value;
        getPropertyChangeSupport().firePropertyChange("previousCityCode", previousValue,
            getPreviousCityCode());
    }

    /**
     * Gets the value of previousCityCode.
     * 
     * @return String the value located at previousCityCode
     */
    public String getPreviousCityCode() {
        return this.previousCityCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setPreviousGarageZipCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getPreviousGarageZipCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setPreviousGarageZipCode(previousValue);
            }
        }
        this.previousGarageZipCode = value;
        getPropertyChangeSupport().firePropertyChange("previousGarageZipCode", previousValue,
            getPreviousGarageZipCode());
    }

    /**
     * Gets the value of previousGarageZipCode.
     * 
     * @return String the value located at previousGarageZipCode
     */
    public String getPreviousGarageZipCode() {
        return this.previousGarageZipCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setPreviousLiabilitySymbolCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getPreviousLiabilitySymbolCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setPreviousLiabilitySymbolCode(previousValue);
            }
        }
        this.previousLiabilitySymbolCode = value;
        getPropertyChangeSupport().firePropertyChange("previousLiabilitySymbolCode", previousValue,
            getPreviousLiabilitySymbolCode());
    }

    /**
     * Gets the value of previousLiabilitySymbolCode.
     * 
     * @return String the value located at previousLiabilitySymbolCode
     */
    public String getPreviousLiabilitySymbolCode() {
        return this.previousLiabilitySymbolCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setPreviousPhysicalDamageSymCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getPreviousPhysicalDamageSymCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setPreviousPhysicalDamageSymCode(previousValue);
            }
        }
        this.previousPhysicalDamageSymCode = value;
        getPropertyChangeSupport().firePropertyChange("previousPhysicalDamageSymCode",
            previousValue, getPreviousPhysicalDamageSymCode());
    }

    /**
     * Gets the value of previousPhysicalDamageSymCode.
     * 
     * @return String the value located at previousPhysicalDamageSymCode
     */
    public String getPreviousPhysicalDamageSymCode() {
        return this.previousPhysicalDamageSymCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setPreviousPhysicalDamageSymCode2(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getPreviousPhysicalDamageSymCode2();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setPreviousPhysicalDamageSymCode2(previousValue);
            }
        }
        this.previousPhysicalDamageSymCode2 = value;
        getPropertyChangeSupport().firePropertyChange("previousPhysicalDamageSymCode2",
            previousValue, getPreviousPhysicalDamageSymCode2());
    }

    /**
     * Gets the value of previousPhysicalDamageSymCode2.
     * 
     * @return String the value located at previousPhysicalDamageSymCode2
     */
    public String getPreviousPhysicalDamageSymCode2() {
        return this.previousPhysicalDamageSymCode2;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setPrimaryIndustryClassificationCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getPrimaryIndustryClassificationCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setPrimaryIndustryClassificationCode(previousValue);
            }
        }
        this.primaryIndustryClassificationCode = value;
        getPropertyChangeSupport().firePropertyChange("primaryIndustryClassificationCode",
            previousValue, getPrimaryIndustryClassificationCode());
    }

    /**
     * Gets the value of primaryIndustryClassificationCode.
     * 
     * @return String the value located at primaryIndustryClassificationCode
     */
    public String getPrimaryIndustryClassificationCode() {
        return this.primaryIndustryClassificationCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setPrimaryIndustrySubClassificationCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getPrimaryIndustrySubClassificationCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setPrimaryIndustrySubClassificationCode(previousValue);
            }
        }
        this.primaryIndustrySubClassificationCode = value;
        getPropertyChangeSupport().firePropertyChange("primaryIndustrySubClassificationCode",
            previousValue, getPrimaryIndustrySubClassificationCode());
    }

    /**
     * Gets the value of primaryIndustrySubClassificationCode.
     * 
     * @return String the value located at primaryIndustrySubClassificationCode
     */
    public String getPrimaryIndustrySubClassificationCode() {
        return this.primaryIndustrySubClassificationCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setPrimaryLiabilityIndicator(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getPrimaryLiabilityIndicator();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setPrimaryLiabilityIndicator(previousValue);
            }
        }
        this.primaryLiabilityIndicator = value;
        getPropertyChangeSupport().firePropertyChange("primaryLiabilityIndicator", previousValue,
            getPrimaryLiabilityIndicator());
    }

    /**
     * Gets the value of primaryLiabilityIndicator.
     * 
     * @return String the value located at primaryLiabilityIndicator
     */
    public String getPrimaryLiabilityIndicator() {
        return this.primaryLiabilityIndicator;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type PriorInsurer
     */
    public void setPriorInsurer(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Object previousValue = getPriorInsurer();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setPriorInsurer(previousValue);
            }
        }
        this.priorInsurerIntegration = value;
        getPropertyChangeSupport().firePropertyChange("priorInsurerIntegration", previousValue,
            getPriorInsurer());
    }

    /**
     * Gets the value of priorInsurerIntegration.
     * 
     * @return PriorInsurer the value located at priorInsurerIntegration
     */
    public Object getPriorInsurer() {
        return this.priorInsurerIntegration;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type PriorInsurerIntegration
     */
    public void setPriorInsurerIntegration(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Object previousValue = getPriorInsurerIntegration();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setPriorInsurerIntegration(previousValue);
            }
        }
        this.priorInsurerIntegration = value;
        getPropertyChangeSupport().firePropertyChange("priorInsurerIntegration", previousValue,
            getPriorInsurerIntegration());
    }

    /**
     * Gets the value of priorInsurerIntegration.
     * 
     * @return PriorInsurerIntegration the value located at priorInsurerIntegration
     */
    public Object getPriorInsurerIntegration() {
        return this.priorInsurerIntegration;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Integer
     */
    public void setPriorTermAnnualMileage(final Integer value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Integer previousValue = getPriorTermAnnualMileage();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setPriorTermAnnualMileage(previousValue);
            }
        }
        this.priorTermAnnualMileage = value;
        getPropertyChangeSupport().firePropertyChange("priorTermAnnualMileage", previousValue,
            getPriorTermAnnualMileage());
    }

    /**
     * Gets the value of priorTermAnnualMileage.
     * 
     * @return Integer the value located at priorTermAnnualMileage
     */
    public Integer getPriorTermAnnualMileage() {
        return this.priorTermAnnualMileage;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setPriorYearCityCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getPriorYearCityCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setPriorYearCityCode(previousValue);
            }
        }
        this.priorYearCityCode = value;
        getPropertyChangeSupport().firePropertyChange("priorYearCityCode", previousValue,
            getPriorYearCityCode());
    }

    /**
     * Gets the value of priorYearCityCode.
     * 
     * @return String the value located at priorYearCityCode
     */
    public String getPriorYearCityCode() {
        return this.priorYearCityCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setPriorYearPostalCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getPriorYearPostalCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setPriorYearPostalCode(previousValue);
            }
        }
        this.priorYearPostalCode = value;
        getPropertyChangeSupport().firePropertyChange("priorYearPostalCode", previousValue,
            getPriorYearPostalCode());
    }

    /**
     * Gets the value of priorYearPostalCode.
     * 
     * @return String the value located at priorYearPostalCode
     */
    public String getPriorYearPostalCode() {
        return this.priorYearPostalCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setPriorYearRiskTerritoryCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getPriorYearRiskTerritoryCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setPriorYearRiskTerritoryCode(previousValue);
            }
        }
        this.priorYearRiskTerritoryCode = value;
        getPropertyChangeSupport().firePropertyChange("priorYearRiskTerritoryCode", previousValue,
            getPriorYearRiskTerritoryCode());
    }

    /**
     * Gets the value of priorYearRiskTerritoryCode.
     * 
     * @return String the value located at priorYearRiskTerritoryCode
     */
    public String getPriorYearRiskTerritoryCode() {
        return this.priorYearRiskTerritoryCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setPurchaseCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getPurchaseCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setPurchaseCode(previousValue);
            }
        }
        this.purchaseCode = value;
        getPropertyChangeSupport().firePropertyChange("purchaseCode", previousValue,
            getPurchaseCode());
    }

    /**
     * Gets the value of purchaseCode.
     * 
     * @return String the value located at purchaseCode
     */
    public String getPurchaseCode() {
        return this.purchaseCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Date
     */
    public void setPurchaseDate(final Date value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Date previousValue = getPurchaseDate();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setPurchaseDate(previousValue);
            }
        }
        this.purchaseDate = value;
        getPropertyChangeSupport().firePropertyChange("purchaseDate", previousValue,
            getPurchaseDate());
    }

    /**
     * Gets the value of purchaseDate.
     * 
     * @return Date the value located at purchaseDate
     */
    public Date getPurchaseDate() {
        return this.purchaseDate;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Boolean
     */
    public void setPurchaseLastThirtyDaysIndicator(final Boolean value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Boolean previousValue = getPurchaseLastThirtyDaysIndicator();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setPurchaseLastThirtyDaysIndicator(previousValue);
            }
        }
        this.purchaseLastThirtyDaysIndicator = value;
        getPropertyChangeSupport().firePropertyChange("purchaseLastThirtyDaysIndicator",
            previousValue, getPurchaseLastThirtyDaysIndicator());
    }

    /**
     * Gets the value of purchaseLastThirtyDaysIndicator.
     * 
     * @return Boolean the value located at purchaseLastThirtyDaysIndicator
     */
    public Boolean getPurchaseLastThirtyDaysIndicator() {
        return this.purchaseLastThirtyDaysIndicator;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Integer
     */
    public void setRatedDriverNumber(final Integer value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Integer previousValue = getRatedDriverNumber();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setRatedDriverNumber(previousValue);
            }
        }
        this.ratedDriverNumber = value;
        getPropertyChangeSupport().firePropertyChange("ratedDriverNumber", previousValue,
            getRatedDriverNumber());
    }

    /**
     * Gets the value of ratedDriverNumber.
     * 
     * @return Integer the value located at ratedDriverNumber
     */
    public Integer getRatedDriverNumber() {
        return this.ratedDriverNumber;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setRatedOperatorTypeCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getRatedOperatorTypeCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setRatedOperatorTypeCode(previousValue);
            }
        }
        this.ratedOperatorTypeCode = value;
        getPropertyChangeSupport().firePropertyChange("ratedOperatorTypeCode", previousValue,
            getRatedOperatorTypeCode());
    }

    /**
     * Gets the value of ratedOperatorTypeCode.
     * 
     * @return String the value located at ratedOperatorTypeCode
     */
    public String getRatedOperatorTypeCode() {
        return this.ratedOperatorTypeCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setRearAxlesOnCommercialVehicle(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getRearAxlesOnCommercialVehicle();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setRearAxlesOnCommercialVehicle(previousValue);
            }
        }
        this.rearAxlesOnCommercialVehicle = value;
        getPropertyChangeSupport().firePropertyChange("rearAxlesOnCommercialVehicle",
            previousValue, getRearAxlesOnCommercialVehicle());
    }

    /**
     * Gets the value of rearAxlesOnCommercialVehicle.
     * 
     * @return String the value located at rearAxlesOnCommercialVehicle
     */
    public String getRearAxlesOnCommercialVehicle() {
        return this.rearAxlesOnCommercialVehicle;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setRegisteredOwnerZipcode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getRegisteredOwnerZipcode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setRegisteredOwnerZipcode(previousValue);
            }
        }
        this.registeredOwnerZipcode = value;
        getPropertyChangeSupport().firePropertyChange("registeredOwnerZipcode", previousValue,
            getRegisteredOwnerZipcode());
    }

    /**
     * Gets the value of registeredOwnerZipcode.
     * 
     * @return String the value located at registeredOwnerZipcode
     */
    public String getRegisteredOwnerZipcode() {
        return this.registeredOwnerZipcode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setRegisteredStateCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getRegisteredStateCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setRegisteredStateCode(previousValue);
            }
        }
        this.registeredStateCode = value;
        getPropertyChangeSupport().firePropertyChange("registeredStateCode", previousValue,
            getRegisteredStateCode());
    }

    /**
     * Gets the value of registeredStateCode.
     * 
     * @return String the value located at registeredStateCode
     */
    public String getRegisteredStateCode() {
        return this.registeredStateCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setRemovalReasonCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getRemovalReasonCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setRemovalReasonCode(previousValue);
            }
        }
        this.removalReasonCode = value;
        getPropertyChangeSupport().firePropertyChange("removalReasonCode", previousValue,
            getRemovalReasonCode());
    }

    /**
     * Gets the value of removalReasonCode.
     * 
     * @return String the value located at removalReasonCode
     */
    public String getRemovalReasonCode() {
        return this.removalReasonCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Integer
     */
    public void setReplacedVehicleUnitNumber(final Integer value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Integer previousValue = getReplacedVehicleUnitNumber();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setReplacedVehicleUnitNumber(previousValue);
            }
        }
        this.replacedVehicleUnitNumber = value;
        getPropertyChangeSupport().firePropertyChange("replacedVehicleUnitNumber", previousValue,
            getReplacedVehicleUnitNumber());
    }

    /**
     * Gets the value of replacedVehicleUnitNumber.
     * 
     * @return Integer the value located at replacedVehicleUnitNumber
     */
    public Integer getReplacedVehicleUnitNumber() {
        return this.replacedVehicleUnitNumber;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setReplacementVehicleIdentifierCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getReplacementVehicleIdentifierCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setReplacementVehicleIdentifierCode(previousValue);
            }
        }
        this.replacementVehicleIdentifierCode = value;
        getPropertyChangeSupport().firePropertyChange("replacementVehicleIdentifierCode",
            previousValue, getReplacementVehicleIdentifierCode());
    }

    /**
     * Gets the value of replacementVehicleIdentifierCode.
     * 
     * @return String the value located at replacementVehicleIdentifierCode
     */
    public String getReplacementVehicleIdentifierCode() {
        return this.replacementVehicleIdentifierCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Date
     */
    public void setRequestedRemovalDate(final Date value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Date previousValue = getRequestedRemovalDate();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setRequestedRemovalDate(previousValue);
            }
        }
        this.requestedRemovalDate = value;
        getPropertyChangeSupport().firePropertyChange("requestedRemovalDate", previousValue,
            getRequestedRemovalDate());
    }

    /**
     * Gets the value of requestedRemovalDate.
     * 
     * @return Date the value located at requestedRemovalDate
     */
    public Date getRequestedRemovalDate() {
        return this.requestedRemovalDate;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setRestrictedCoverageReasonCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getRestrictedCoverageReasonCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setRestrictedCoverageReasonCode(previousValue);
            }
        }
        this.restrictedCoverageReasonCode = value;
        getPropertyChangeSupport().firePropertyChange("restrictedCoverageReasonCode",
            previousValue, getRestrictedCoverageReasonCode());
    }

    /**
     * Gets the value of restrictedCoverageReasonCode.
     * 
     * @return String the value located at restrictedCoverageReasonCode
     */
    public String getRestrictedCoverageReasonCode() {
        return this.restrictedCoverageReasonCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setRestrictedCoverageTypeCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getRestrictedCoverageTypeCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setRestrictedCoverageTypeCode(previousValue);
            }
        }
        this.restrictedCoverageTypeCode = value;
        getPropertyChangeSupport().firePropertyChange("restrictedCoverageTypeCode", previousValue,
            getRestrictedCoverageTypeCode());
    }

    /**
     * Gets the value of restrictedCoverageTypeCode.
     * 
     * @return String the value located at restrictedCoverageTypeCode
     */
    public String getRestrictedCoverageTypeCode() {
        return this.restrictedCoverageTypeCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setRestrictedVehicleCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getRestrictedVehicleCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setRestrictedVehicleCode(previousValue);
            }
        }
        this.restrictedVehicleCode = value;
        getPropertyChangeSupport().firePropertyChange("restrictedVehicleCode", previousValue,
            getRestrictedVehicleCode());
    }

    /**
     * Gets the value of restrictedVehicleCode.
     * 
     * @return String the value located at restrictedVehicleCode
     */
    public String getRestrictedVehicleCode() {
        return this.restrictedVehicleCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setRiskCityName(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getRiskCityName();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setRiskCityName(previousValue);
            }
        }
        this.riskCityName = value;
        getPropertyChangeSupport().firePropertyChange("riskCityName", previousValue,
            getRiskCityName());
    }

    /**
     * Gets the value of riskCityName.
     * 
     * @return String the value located at riskCityName
     */
    public String getRiskCityName() {
        return this.riskCityName;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setRiskCountyCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getRiskCountyCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setRiskCountyCode(previousValue);
            }
        }
        this.riskCountyCode = value;
        getPropertyChangeSupport().firePropertyChange("riskCountyCode", previousValue,
            getRiskCountyCode());
    }

    /**
     * Gets the value of riskCountyCode.
     * 
     * @return String the value located at riskCountyCode
     */
    public String getRiskCountyCode() {
        return this.riskCountyCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setRiskStateCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getRiskStateCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setRiskStateCode(previousValue);
            }
        }
        this.riskStateCode = value;
        getPropertyChangeSupport().firePropertyChange("riskStateCode", previousValue,
            getRiskStateCode());
    }

    /**
     * Gets the value of riskStateCode.
     * 
     * @return String the value located at riskStateCode
     */
    public String getRiskStateCode() {
        return this.riskStateCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setRiskStatisticalCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getRiskStatisticalCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setRiskStatisticalCode(previousValue);
            }
        }
        this.riskStatisticalCode = value;
        getPropertyChangeSupport().firePropertyChange("riskStatisticalCode", previousValue,
            getRiskStatisticalCode());
    }

    /**
     * Gets the value of riskStatisticalCode.
     * 
     * @return String the value located at riskStatisticalCode
     */
    public String getRiskStatisticalCode() {
        return this.riskStatisticalCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setRiskTerritoryCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getRiskTerritoryCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setRiskTerritoryCode(previousValue);
            }
        }
        this.riskTerritoryCode = value;
        getPropertyChangeSupport().firePropertyChange("riskTerritoryCode", previousValue,
            getRiskTerritoryCode());
    }

    /**
     * Gets the value of riskTerritoryCode.
     * 
     * @return String the value located at riskTerritoryCode
     */
    public String getRiskTerritoryCode() {
        return this.riskTerritoryCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setRiskTerritoryConfidencePercent(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getRiskTerritoryConfidencePercent();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setRiskTerritoryConfidencePercent(previousValue);
            }
        }
        this.riskTerritoryConfidencePercent = value;
        getPropertyChangeSupport().firePropertyChange("riskTerritoryConfidencePercent",
            previousValue, getRiskTerritoryConfidencePercent());
    }

    /**
     * Gets the value of riskTerritoryConfidencePercent.
     * 
     * @return String the value located at riskTerritoryConfidencePercent
     */
    public String getRiskTerritoryConfidencePercent() {
        return this.riskTerritoryConfidencePercent;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setRiskZipCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getRiskZipCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setRiskZipCode(previousValue);
            }
        }
        this.riskZipCode = value;
        getPropertyChangeSupport().firePropertyChange("riskZipCode", previousValue,
            getRiskZipCode());
    }

    /**
     * Gets the value of riskZipCode.
     * 
     * @return String the value located at riskZipCode
     */
    public String getRiskZipCode() {
        return this.riskZipCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Integer
     */
    public void setRvDaysOccupiedPerYear(final Integer value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Integer previousValue = getRvDaysOccupiedPerYear();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setRvDaysOccupiedPerYear(previousValue);
            }
        }
        this.rvDaysOccupiedPerYear = value;
        getPropertyChangeSupport().firePropertyChange("rvDaysOccupiedPerYear", previousValue,
            getRvDaysOccupiedPerYear());
    }

    /**
     * Gets the value of rvDaysOccupiedPerYear.
     * 
     * @return Integer the value located at rvDaysOccupiedPerYear
     */
    public Integer getRvDaysOccupiedPerYear() {
        return this.rvDaysOccupiedPerYear;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setSoleOwnerResponseCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getSoleOwnerResponseCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setSoleOwnerResponseCode(previousValue);
            }
        }
        this.soleOwnerResponseCode = value;
        getPropertyChangeSupport().firePropertyChange("soleOwnerResponseCode", previousValue,
            getSoleOwnerResponseCode());
    }

    /**
     * Gets the value of soleOwnerResponseCode.
     * 
     * @return String the value located at soleOwnerResponseCode
     */
    public String getSoleOwnerResponseCode() {
        return this.soleOwnerResponseCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type java.math.BigDecimal
     */
    public void setStatedAmount(final java.math.BigDecimal value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final java.math.BigDecimal previousValue = getStatedAmount();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setStatedAmount(previousValue);
            }
        }
        this.statedAmount = value;
        getPropertyChangeSupport().firePropertyChange("statedAmount", previousValue,
            getStatedAmount());
    }

    /**
     * Gets the value of statedAmount.
     * 
     * @return java.math.BigDecimal the value located at statedAmount
     */
    public java.math.BigDecimal getStatedAmount() {
        return this.statedAmount;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setStatisticReportingCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getStatisticReportingCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setStatisticReportingCode(previousValue);
            }
        }
        this.statisticReportingCode = value;
        getPropertyChangeSupport().firePropertyChange("statisticReportingCode", previousValue,
            getStatisticReportingCode());
    }

    /**
     * Gets the value of statisticReportingCode.
     * 
     * @return String the value located at statisticReportingCode
     */
    public String getStatisticReportingCode() {
        return this.statisticReportingCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setStatusCode(final String value) {

        if (checkReadOnly()) {
            return;
        }
    }

    /**
     * Gets the value of statusCode.
     * 
     * @return String the value located at statusCode
     */
    public String getStatusCode() {
        return null;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Boolean
     */
    public void setStructuralModificationIndicator(final Boolean value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Boolean previousValue = getStructuralModificationIndicator();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setStructuralModificationIndicator(previousValue);
            }
        }
        this.structuralModificationIndicator = value;
        getPropertyChangeSupport().firePropertyChange("structuralModificationIndicator",
            previousValue, getStructuralModificationIndicator());
    }

    /**
     * Gets the value of structuralModificationIndicator.
     * 
     * @return Boolean the value located at structuralModificationIndicator
     */
    public Boolean getStructuralModificationIndicator() {
        return this.structuralModificationIndicator;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setStyle(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getStyle();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setStyle(previousValue);
            }
        }
        this.style = value;
        getPropertyChangeSupport().firePropertyChange("style", previousValue, getStyle());
    }

    /**
     * Gets the value of style.
     * 
     * @return String the value located at style
     */
    public String getStyle() {
        return this.style;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setSymbolOverrideCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getSymbolOverrideCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setSymbolOverrideCode(previousValue);
            }
        }
        this.symbolOverrideCode = value;
        getPropertyChangeSupport().firePropertyChange("symbolOverrideCode", previousValue,
            getSymbolOverrideCode());
    }

    /**
     * Gets the value of symbolOverrideCode.
     * 
     * @return String the value located at symbolOverrideCode
     */
    public String getSymbolOverrideCode() {
        return this.symbolOverrideCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setSymbolOverrideCode2(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getSymbolOverrideCode2();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setSymbolOverrideCode2(previousValue);
            }
        }
        this.symbolOverrideCode2 = value;
        getPropertyChangeSupport().firePropertyChange("symbolOverrideCode2", previousValue,
            getSymbolOverrideCode2());
    }

    /**
     * Gets the value of symbolOverrideCode2.
     * 
     * @return String the value located at symbolOverrideCode2
     */
    public String getSymbolOverrideCode2() {
        return this.symbolOverrideCode2;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Date
     */
    public void setTagSurrenderDate(final Date value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Date previousValue = getTagSurrenderDate();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setTagSurrenderDate(previousValue);
            }
        }
        this.tagSurrenderDate = value;
        getPropertyChangeSupport().firePropertyChange("tagSurrenderDate", previousValue,
            getTagSurrenderDate());
    }

    /**
     * Gets the value of tagSurrenderDate.
     * 
     * @return Date the value located at tagSurrenderDate
     */
    public Date getTagSurrenderDate() {
        return this.tagSurrenderDate;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setTagSurrenderReceiptNumber(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getTagSurrenderReceiptNumber();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setTagSurrenderReceiptNumber(previousValue);
            }
        }
        this.tagSurrenderReceiptNumber = value;
        getPropertyChangeSupport().firePropertyChange("tagSurrenderReceiptNumber", previousValue,
            getTagSurrenderReceiptNumber());
    }

    /**
     * Gets the value of tagSurrenderReceiptNumber.
     * 
     * @return String the value located at tagSurrenderReceiptNumber
     */
    public String getTagSurrenderReceiptNumber() {
        return this.tagSurrenderReceiptNumber;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setTaxLocationCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getTaxLocationCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setTaxLocationCode(previousValue);
            }
        }
        this.taxLocationCode = value;
        getPropertyChangeSupport().firePropertyChange("taxLocationCode", previousValue,
            getTaxLocationCode());
    }

    /**
     * Gets the value of taxLocationCode.
     * 
     * @return String the value located at taxLocationCode
     */
    public String getTaxLocationCode() {
        return this.taxLocationCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setTaxLocationConfidencePercent(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getTaxLocationConfidencePercent();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setTaxLocationConfidencePercent(previousValue);
            }
        }
        this.taxLocationConfidencePercent = value;
        getPropertyChangeSupport().firePropertyChange("taxLocationConfidencePercent",
            previousValue, getTaxLocationConfidencePercent());
    }

    /**
     * Gets the value of taxLocationConfidencePercent.
     * 
     * @return String the value located at taxLocationConfidencePercent
     */
    public String getTaxLocationConfidencePercent() {
        return this.taxLocationConfidencePercent;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setTaxLocationLowConfidence(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getTaxLocationLowConfidence();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setTaxLocationLowConfidence(previousValue);
            }
        }
        this.taxLocationLowConfidence = value;
        getPropertyChangeSupport().firePropertyChange("taxLocationLowConfidence", previousValue,
            getTaxLocationLowConfidence());
    }

    /**
     * Gets the value of taxLocationLowConfidence.
     * 
     * @return String the value located at taxLocationLowConfidence
     */
    public String getTaxLocationLowConfidence() {
        return this.taxLocationLowConfidence;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setTaxLocationOverrideCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getTaxLocationOverrideCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setTaxLocationOverrideCode(previousValue);
            }
        }
        this.taxLocationOverrideCode = value;
        getPropertyChangeSupport().firePropertyChange("taxLocationOverrideCode", previousValue,
            getTaxLocationOverrideCode());
    }

    /**
     * Gets the value of taxLocationOverrideCode.
     * 
     * @return String the value located at taxLocationOverrideCode
     */
    public String getTaxLocationOverrideCode() {
        return this.taxLocationOverrideCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setTaxLocationSource(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getTaxLocationSource();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setTaxLocationSource(previousValue);
            }
        }
        this.taxLocationSource = value;
        getPropertyChangeSupport().firePropertyChange("taxLocationSource", previousValue,
            getTaxLocationSource());
    }

    /**
     * Gets the value of taxLocationSource.
     * 
     * @return String the value located at taxLocationSource
     */
    public String getTaxLocationSource() {
        return this.taxLocationSource;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setTemporaryVehicleVinNumber(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getTemporaryVehicleVinNumber();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setTemporaryVehicleVinNumber(previousValue);
            }
        }
        this.temporaryVehicleVinNumber = value;
        getPropertyChangeSupport().firePropertyChange("temporaryVehicleVinNumber", previousValue,
            getTemporaryVehicleVinNumber());
    }

    /**
     * Gets the value of temporaryVehicleVinNumber.
     * 
     * @return String the value located at temporaryVehicleVinNumber
     */
    public String getTemporaryVehicleVinNumber() {
        return this.temporaryVehicleVinNumber;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setTerritoryCodeSourceSystemCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getTerritoryCodeSourceSystemCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setTerritoryCodeSourceSystemCode(previousValue);
            }
        }
        this.territoryCodeSourceSystemCode = value;
        getPropertyChangeSupport().firePropertyChange("territoryCodeSourceSystemCode",
            previousValue, getTerritoryCodeSourceSystemCode());
    }

    /**
     * Gets the value of territoryCodeSourceSystemCode.
     * 
     * @return String the value located at territoryCodeSourceSystemCode
     */
    public String getTerritoryCodeSourceSystemCode() {
        return this.territoryCodeSourceSystemCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setTerritoryOverrideCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getTerritoryOverrideCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setTerritoryOverrideCode(previousValue);
            }
        }
        this.territoryOverrideCode = value;
        getPropertyChangeSupport().firePropertyChange("territoryOverrideCode", previousValue,
            getTerritoryOverrideCode());
    }

    /**
     * Gets the value of territoryOverrideCode.
     * 
     * @return String the value located at territoryOverrideCode
     */
    public String getTerritoryOverrideCode() {
        return this.territoryOverrideCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Boolean
     */
    public void setTortIndicator(final Boolean value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Boolean previousValue = getTortIndicator();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setTortIndicator(previousValue);
            }
        }
        this.tortIndicator = value;
        getPropertyChangeSupport().firePropertyChange("tortIndicator", previousValue,
            getTortIndicator());
    }

    /**
     * Gets the value of tortIndicator.
     * 
     * @return Boolean the value located at tortIndicator
     */
    public Boolean getTortIndicator() {
        return this.tortIndicator;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Boolean
     */
    public void setUndeleted(final Boolean value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Boolean previousValue = getUndeleted();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setUndeleted(previousValue);
            }
        }
        this.undeleted = value;
        getPropertyChangeSupport().firePropertyChange("undeleted", previousValue, getUndeleted());
    }

    /**
     * Gets the value of undeleted.
     * 
     * @return Boolean the value located at undeleted
     */
    public Boolean getUndeleted() {
        return this.undeleted;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setVandalismTheftCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getVandalismTheftCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setVandalismTheftCode(previousValue);
            }
        }
        this.vandalismTheftCode = value;
        getPropertyChangeSupport().firePropertyChange("vandalismTheftCode", previousValue,
            getVandalismTheftCode());
    }

    /**
     * Gets the value of vandalismTheftCode.
     * 
     * @return String the value located at vandalismTheftCode
     */
    public String getVandalismTheftCode() {
        return this.vandalismTheftCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setVehicleAgeGroupCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getVehicleAgeGroupCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setVehicleAgeGroupCode(previousValue);
            }
        }
        this.vehicleAgeGroupCode = value;
        getPropertyChangeSupport().firePropertyChange("vehicleAgeGroupCode", previousValue,
            getVehicleAgeGroupCode());
    }

    /**
     * Gets the value of vehicleAgeGroupCode.
     * 
     * @return String the value located at vehicleAgeGroupCode
     */
    public String getVehicleAgeGroupCode() {
        return this.vehicleAgeGroupCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setVehicleBodyCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getVehicleBodyCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setVehicleBodyCode(previousValue);
            }
        }
        this.vehicleBodyCode = value;
        getPropertyChangeSupport().firePropertyChange("vehicleBodyCode", previousValue,
            getVehicleBodyCode());
    }

    /**
     * Gets the value of vehicleBodyCode.
     * 
     * @return String the value located at vehicleBodyCode
     */
    public String getVehicleBodyCode() {
        return this.vehicleBodyCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setVehicleBodyStyleCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getVehicleBodyStyleCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setVehicleBodyStyleCode(previousValue);
            }
        }
        this.vehicleBodyStyleCode = value;
        getPropertyChangeSupport().firePropertyChange("vehicleBodyStyleCode", previousValue,
            getVehicleBodyStyleCode());
    }

    /**
     * Gets the value of vehicleBodyStyleCode.
     * 
     * @return String the value located at vehicleBodyStyleCode
     */
    public String getVehicleBodyStyleCode() {
        return this.vehicleBodyStyleCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setVehicleCarPoolIndicator(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getVehicleCarPoolIndicator();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setVehicleCarPoolIndicator(previousValue);
            }
        }
        this.vehicleCarPoolIndicator = value;
        getPropertyChangeSupport().firePropertyChange("vehicleCarPoolIndicator", previousValue,
            getVehicleCarPoolIndicator());
    }

    /**
     * Gets the value of vehicleCarPoolIndicator.
     * 
     * @return String the value located at vehicleCarPoolIndicator
     */
    public String getVehicleCarPoolIndicator() {
        return this.vehicleCarPoolIndicator;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setVehicleConditionCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getVehicleConditionCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setVehicleConditionCode(previousValue);
            }
        }
        this.vehicleConditionCode = value;
        getPropertyChangeSupport().firePropertyChange("vehicleConditionCode", previousValue,
            getVehicleConditionCode());
    }

    /**
     * Gets the value of vehicleConditionCode.
     * 
     * @return String the value located at vehicleConditionCode
     */
    public String getVehicleConditionCode() {
        return this.vehicleConditionCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setVehicleConditionSubtypeCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getVehicleConditionSubtypeCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setVehicleConditionSubtypeCode(previousValue);
            }
        }
        this.vehicleConditionSubtypeCode = value;
        getPropertyChangeSupport().firePropertyChange("vehicleConditionSubtypeCode", previousValue,
            getVehicleConditionSubtypeCode());
    }

    /**
     * Gets the value of vehicleConditionSubtypeCode.
     * 
     * @return String the value located at vehicleConditionSubtypeCode
     */
    public String getVehicleConditionSubtypeCode() {
        return this.vehicleConditionSubtypeCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type java.math.BigDecimal
     */
    public void setVehicleContentsAmount(final java.math.BigDecimal value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final java.math.BigDecimal previousValue = getVehicleContentsAmount();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setVehicleContentsAmount(previousValue);
            }
        }
        this.vehicleContentsAmount = value;
        getPropertyChangeSupport().firePropertyChange("vehicleContentsAmount", previousValue,
            getVehicleContentsAmount());
    }

    /**
     * Gets the value of vehicleContentsAmount.
     * 
     * @return java.math.BigDecimal the value located at vehicleContentsAmount
     */
    public java.math.BigDecimal getVehicleContentsAmount() {
        return this.vehicleContentsAmount;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type VehicleCustomization
     */
    public void setVehicleCustomization(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Object previousValue = getVehicleCustomization();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setVehicleCustomization(previousValue);
            }
        }
        this.vehicleCustomizationIntegration = value;
        getPropertyChangeSupport().firePropertyChange("vehicleCustomizationIntegration",
            previousValue, getVehicleCustomization());
    }

    /**
     * Gets the value of vehicleCustomizationIntegration.
     * 
     * @return VehicleCustomization the value located at vehicleCustomizationIntegration
     */
    public Object getVehicleCustomization() {
        return this.vehicleCustomizationIntegration;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type VehicleCustomizationIntegration
     */
    public void setVehicleCustomizationIntegration(final Object value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Object previousValue = getVehicleCustomizationIntegration();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setVehicleCustomizationIntegration(previousValue);
            }
        }
        this.vehicleCustomizationIntegration = value;
        getPropertyChangeSupport().firePropertyChange("vehicleCustomizationIntegration",
            previousValue, getVehicleCustomizationIntegration());
    }

    /**
     * Gets the value of vehicleCustomizationIntegration.
     * 
     * @return VehicleCustomizationIntegration the value located at vehicleCustomizationIntegration
     */
    public Object getVehicleCustomizationIntegration() {
        return this.vehicleCustomizationIntegration;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setVehicleDamage(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getVehicleDamage();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setVehicleDamage(previousValue);
            }
        }
        this.vehicleDamage = value;
        getPropertyChangeSupport().firePropertyChange("vehicleDamage", previousValue,
            getVehicleDamage());
    }

    /**
     * Gets the value of vehicleDamage.
     * 
     * @return String the value located at vehicleDamage
     */
    public String getVehicleDamage() {
        return this.vehicleDamage;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setVehicleDrivenForCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getVehicleDrivenForCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setVehicleDrivenForCode(previousValue);
            }
        }
        this.vehicleDrivenForCode = value;
        getPropertyChangeSupport().firePropertyChange("vehicleDrivenForCode", previousValue,
            getVehicleDrivenForCode());
    }

    /**
     * Gets the value of vehicleDrivenForCode.
     * 
     * @return String the value located at vehicleDrivenForCode
     */
    public String getVehicleDrivenForCode() {
        return this.vehicleDrivenForCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setVehicleIsFinanaced(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getVehicleIsFinanaced();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setVehicleIsFinanaced(previousValue);
            }
        }
        this.vehicleIsFinanaced = value;
        getPropertyChangeSupport().firePropertyChange("vehicleIsFinanaced", previousValue,
            getVehicleIsFinanaced());
    }

    /**
     * Gets the value of vehicleIsFinanaced.
     * 
     * @return String the value located at vehicleIsFinanaced
     */
    public String getVehicleIsFinanaced() {
        return this.vehicleIsFinanaced;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setVehicleLocationCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getVehicleLocationCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setVehicleLocationCode(previousValue);
            }
        }
        this.vehicleLocationCode = value;
        getPropertyChangeSupport().firePropertyChange("vehicleLocationCode", previousValue,
            getVehicleLocationCode());
    }

    /**
     * Gets the value of vehicleLocationCode.
     * 
     * @return String the value located at vehicleLocationCode
     */
    public String getVehicleLocationCode() {
        return this.vehicleLocationCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setVehicleMakeCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getVehicleMakeCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setVehicleMakeCode(previousValue);
            }
        }
        this.vehicleMakeCode = value;
        getPropertyChangeSupport().firePropertyChange("vehicleMakeCode", previousValue,
            getVehicleMakeCode());
    }

    /**
     * Gets the value of vehicleMakeCode.
     * 
     * @return String the value located at vehicleMakeCode
     */
    public String getVehicleMakeCode() {
        return this.vehicleMakeCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setVehicleMechanicalBreakdownInsuranceAge(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getVehicleMechanicalBreakdownInsuranceAge();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setVehicleMechanicalBreakdownInsuranceAge(previousValue);
            }
        }
        this.vehicleMechanicalBreakdownInsuranceAge = value;
        getPropertyChangeSupport().firePropertyChange("vehicleMechanicalBreakdownInsuranceAge",
            previousValue, getVehicleMechanicalBreakdownInsuranceAge());
    }

    /**
     * Gets the value of vehicleMechanicalBreakdownInsuranceAge.
     * 
     * @return String the value located at vehicleMechanicalBreakdownInsuranceAge
     */
    public String getVehicleMechanicalBreakdownInsuranceAge() {
        return this.vehicleMechanicalBreakdownInsuranceAge;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setVehicleModelCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getVehicleModelCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setVehicleModelCode(previousValue);
            }
        }
        this.vehicleModelCode = value;
        getPropertyChangeSupport().firePropertyChange("vehicleModelCode", previousValue,
            getVehicleModelCode());
    }

    /**
     * Gets the value of vehicleModelCode.
     * 
     * @return String the value located at vehicleModelCode
     */
    public String getVehicleModelCode() {
        return this.vehicleModelCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Integer
     */
    public void setVehicleModelYear(final Integer value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Integer previousValue = getVehicleModelYear();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setVehicleModelYear(previousValue);
            }
        }
        this.vehicleModelYear = value;
        getPropertyChangeSupport().firePropertyChange("vehicleModelYear", previousValue,
            getVehicleModelYear());
    }

    /**
     * Gets the value of vehicleModelYear.
     * 
     * @return Integer the value located at vehicleModelYear
     */
    public Integer getVehicleModelYear() {
        return this.vehicleModelYear;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setVehicleOwnershipCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getVehicleOwnershipCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setVehicleOwnershipCode(previousValue);
            }
        }
        this.vehicleOwnershipCode = value;
        getPropertyChangeSupport().firePropertyChange("vehicleOwnershipCode", previousValue,
            getVehicleOwnershipCode());
    }

    /**
     * Gets the value of vehicleOwnershipCode.
     * 
     * @return String the value located at vehicleOwnershipCode
     */
    public String getVehicleOwnershipCode() {
        return this.vehicleOwnershipCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setVehiclePerformanceCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getVehiclePerformanceCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setVehiclePerformanceCode(previousValue);
            }
        }
        this.vehiclePerformanceCode = value;
        getPropertyChangeSupport().firePropertyChange("vehiclePerformanceCode", previousValue,
            getVehiclePerformanceCode());
    }

    /**
     * Gets the value of vehiclePerformanceCode.
     * 
     * @return String the value located at vehiclePerformanceCode
     */
    public String getVehiclePerformanceCode() {
        return this.vehiclePerformanceCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setVehiclePointsOverrideIndicator(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getVehiclePointsOverrideIndicator();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setVehiclePointsOverrideIndicator(previousValue);
            }
        }
        this.vehiclePointsOverrideIndicator = value;
        getPropertyChangeSupport().firePropertyChange("vehiclePointsOverrideIndicator",
            previousValue, getVehiclePointsOverrideIndicator());
    }

    /**
     * Gets the value of vehiclePointsOverrideIndicator.
     * 
     * @return String the value located at vehiclePointsOverrideIndicator
     */
    public String getVehiclePointsOverrideIndicator() {
        return this.vehiclePointsOverrideIndicator;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Integer
     */
    public void setVehicleRank(final Integer value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Integer previousValue = getVehicleRank();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setVehicleRank(previousValue);
            }
        }
        this.vehicleRank = value;
        getPropertyChangeSupport().firePropertyChange("vehicleRank", previousValue,
            getVehicleRank());
    }

    /**
     * Gets the value of vehicleRank.
     * 
     * @return Integer the value located at vehicleRank
     */
    public Integer getVehicleRank() {
        return this.vehicleRank;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setVehicleReasonAmendedCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getVehicleReasonAmendedCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPreviousIntegration().setVehicleReasonAmendedCode(previousValue);
            }
        }
        this.vehicleReasonAmendedCode = value;
        getPropertyChangeSupport().firePropertyChange("vehicleReasonAmendedCode", previousValue,
            getVehicleReasonAmendedCode());
    }

    /**
     * Gets the value of vehicleReasonAmendedCode.
     * 
     * @return String the value located at vehicleReasonAmendedCode
     */
    public String getVehicleReasonAmendedCode() {
        return this.vehicleReasonAmendedCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setVehicleSymbolCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getVehicleSymbolCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setVehicleSymbolCode(previousValue);
            }
        }
        this.vehicleSymbolCode = value;
        getPropertyChangeSupport().firePropertyChange("vehicleSymbolCode", previousValue,
            getVehicleSymbolCode());
    }

    /**
     * Gets the value of vehicleSymbolCode.
     * 
     * @return String the value located at vehicleSymbolCode
     */
    public String getVehicleSymbolCode() {
        return this.vehicleSymbolCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setVehicleSymbolCode2(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getVehicleSymbolCode2();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setVehicleSymbolCode2(previousValue);
            }
        }
        this.vehicleSymbolCode2 = value;
        getPropertyChangeSupport().firePropertyChange("vehicleSymbolCode2", previousValue,
            getVehicleSymbolCode2());
    }

    /**
     * Gets the value of vehicleSymbolCode2.
     * 
     * @return String the value located at vehicleSymbolCode2
     */
    public String getVehicleSymbolCode2() {
        return this.vehicleSymbolCode2;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setVehicleTagNumber(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getVehicleTagNumber();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setVehicleTagNumber(previousValue);
            }
        }
        this.vehicleTagNumber = value;
        getPropertyChangeSupport().firePropertyChange("vehicleTagNumber", previousValue,
            getVehicleTagNumber());
    }

    /**
     * Gets the value of vehicleTagNumber.
     * 
     * @return String the value located at vehicleTagNumber
     */
    public String getVehicleTagNumber() {
        return this.vehicleTagNumber;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setVehicleTierCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getVehicleTierCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setVehicleTierCode(previousValue);
            }
        }
        this.vehicleTierCode = value;
        getPropertyChangeSupport().firePropertyChange("vehicleTierCode", previousValue,
            getVehicleTierCode());
    }

    /**
     * Gets the value of vehicleTierCode.
     * 
     * @return String the value located at vehicleTierCode
     */
    public String getVehicleTierCode() {
        return this.vehicleTierCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setVehicleTypeCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getVehicleTypeCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setVehicleTypeCode(previousValue);
            }
        }
        this.vehicleTypeCode = value;
        getPropertyChangeSupport().firePropertyChange("vehicleTypeCode", previousValue,
            getVehicleTypeCode());
    }

    /**
     * Gets the value of vehicleTypeCode.
     * 
     * @return String the value located at vehicleTypeCode
     */
    public String getVehicleTypeCode() {
        return this.vehicleTypeCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Integer
     */
    public void setVehicleUnitNumber(final Integer value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Integer previousValue = getVehicleUnitNumber();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setVehicleUnitNumber(previousValue);
            }
        }
        this.vehicleUnitNumber = value;
        getPropertyChangeSupport().firePropertyChange("vehicleUnitNumber", previousValue,
            getVehicleUnitNumber());
    }

    /**
     * Gets the value of vehicleUnitNumber.
     * 
     * @return Integer the value located at vehicleUnitNumber
     */
    public Integer getVehicleUnitNumber() {
        return this.vehicleUnitNumber;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setVehicleUseCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getVehicleUseCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setVehicleUseCode(previousValue);
            }
        }
        this.vehicleUseCode = value;
        getPropertyChangeSupport().firePropertyChange("vehicleUseCode", previousValue,
            getVehicleUseCode());
    }

    /**
     * Gets the value of vehicleUseCode.
     * 
     * @return String the value located at vehicleUseCode
     */
    public String getVehicleUseCode() {
        return this.vehicleUseCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setVehicleUseDrivers(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getVehicleUseDrivers();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setVehicleUseDrivers(previousValue);
            }
        }
        this.vehicleUseDrivers = value;
        getPropertyChangeSupport().firePropertyChange("vehicleUseDrivers", previousValue,
            getVehicleUseDrivers());
    }

    /**
     * Gets the value of vehicleUseDrivers.
     * 
     * @return String the value located at vehicleUseDrivers
     */
    public String getVehicleUseDrivers() {
        return this.vehicleUseDrivers;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Boolean
     */
    public void setVehicleVinIndicator(final Boolean value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Boolean previousValue = getVehicleVinIndicator();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setVehicleVinIndicator(previousValue);
            }
        }
        this.vehicleVinIndicator = value;
        getPropertyChangeSupport().firePropertyChange("vehicleVinIndicator", previousValue,
            getVehicleVinIndicator());
    }

    /**
     * Gets the value of vehicleVinIndicator.
     * 
     * @return Boolean the value located at vehicleVinIndicator
     */
    public Boolean getVehicleVinIndicator() {
        return this.vehicleVinIndicator;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setVehicleVinNumber(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getVehicleVinNumber();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setVehicleVinNumber(previousValue);
            }
        }
        this.vehicleVinNumber = value;
        getPropertyChangeSupport().firePropertyChange("vehicleVinNumber", previousValue,
            getVehicleVinNumber());
    }

    /**
     * Gets the value of vehicleVinNumber.
     * 
     * @return String the value located at vehicleVinNumber
     */
    public String getVehicleVinNumber() {
        return this.vehicleVinNumber;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type String
     */
    public void setVehicleZipCode(final String value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final String previousValue = getVehicleZipCode();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setVehicleZipCode(previousValue);
            }
        }
        this.vehicleZipCode = value;
        getPropertyChangeSupport().firePropertyChange("vehicleZipCode", previousValue,
            getVehicleZipCode());
    }

    /**
     * Gets the value of vehicleZipCode.
     * 
     * @return String the value located at vehicleZipCode
     */
    public String getVehicleZipCode() {
        return this.vehicleZipCode;
    }

    /**
     * Sets the value. Takes no action if the object is read only
     * 
     * @param value sets value of type Integer
     */
    public void setYear(final Integer value) {

        if (checkReadOnly()) {
            return;
        }

        // save the previous value for bean property support
        final Integer previousValue = getYear();

        if (isPreviousSupportEnabled()) {
            if (null == previous) {
                previous = copy();
            } else {
                getPrevious().setYear(previousValue);
            }
        }
        this.year = value;
        getPropertyChangeSupport().firePropertyChange("year", previousValue, getYear());
    }

    /**
     * Gets the value of year.
     * 
     * @return Integer the value located at year
     */
    public Integer getYear() {
        return this.year;
    }

    public Vehicle getPrevious() {
        return previous;
    }

    public void setPrevious(final Vehicle previous) {
        this.previous = previous;
    }

    public Vehicle getPreviousIntegration() {
        return null;
    }

    public Vehicle getLastIssued() {
        return null;
    }

    public void setLastIssued(final Vehicle lastIssued) {}

    public Vehicle getLastIssuedIntegration() {
        return null;
    }

    public void setLastIssuedIntegration(final Vehicle lastIssued) {}

    public List<Object> compareAttributes(final Object entity) {
        return null;
    }

    public List<Object> compareIntegrationAttributes(final Object entity) {
        return null;
    }

    public Class<?> getBusinessInterface() {
        return Vehicle.class;
    }

    public Class<?> getIntegrationInterface() {
        return Vehicle.class;
    }

    public Object initialize(final Object parent) {
        return this;
    }

    private transient Vehicle behaviorDelegate = null;

    public Vehicle behaviorDelegate() {
        return null;
    }

    public static final class PreviousVehicle extends Vehicle {

        // implements PreviousCPSEntity {

        /** standard serialization serialVersionUID */
        private static final long serialVersionUID = 1162154324L;

        /** constructor for PreviousVehicleIntegrationImpl() */
        public PreviousVehicle() {
            super();
        }

        @Override
        public void setPreviousSupportEnabled(final boolean enabled) {
            // never enable support for previous objects
        }

        @Override
        public boolean isPreviousSupportEnabled() {
            return false;
        }

        @Override
        public Vehicle getPrevious() {
            return null;
        }

        @Override
        public void setPrevious(final Vehicle previous) {
            throw new UnsupportedOperationException(
                "previous is not supported in PreviousVehicleIntegrationImpl");
        }

        @Override
        public Vehicle getPreviousIntegration() {
            return null;
        }
    }

    /**
     * a LastIssuedVehicleIntegrationImpl that extends VehicleIntegrationImpl
     */
    public static final class LastIssuedVehicle extends Vehicle {

        // implements LastIssuedCPSEntity {

        /** standard serialization serialVersionUID */
        private static final long serialVersionUID = 1162154324L;

        /** constructor for LastIssuedVehicleIntegrationImpl() */
        public LastIssuedVehicle() {
            super();
        }

        @Override
        public void setPreviousSupportEnabled(final boolean enabled) {
            // never enable support for previous objects
        }

        @Override
        public boolean isPreviousSupportEnabled() {
            return false;
        }

        @Override
        public Vehicle getPrevious() {
            return null;
        }

        @Override
        public void setPrevious(final Vehicle previous) {
            throw new UnsupportedOperationException(
                "previous is not supported in LastIssuedVehicleIntegrationImpl");
        }

        @Override
        public Vehicle getPreviousIntegration() {
            return null;
        }
    }

}
