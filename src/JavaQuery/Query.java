/*package org.bimserver.querycompiler;

import java.io.PrintWriter;
import org.bimserver.plugins.serializers.IfcModelInterface;
import java.util.*;


import org.bimserver.models.ifc2x3.*;

public class Query implements QueryInterface {

private IfcModelInterface model;
private PrintWriter out;
private List<Double> list_of_storey_elevation = new ArrayList();

@Override
public void query(IfcModelInterface model, PrintWriter out) {

List<IfcBuildingStorey> stories = model.getAll(IfcBuildingStorey.class);

Map<Double, IfcBuildingStorey> orderedStories = new TreeMap<Double, IfcBuildingStorey>();

this.list_of_storey_elevation = new ArrayList();

for (IfcBuildingStorey storey : stories) {
orderedStories.put(storey.getElevation(), storey);
this.list_of_storey_elevation.add(storey.getElevation());
System.out.println("storey elevation: " + storey.getElevation());
}

Collections.sort(this.list_of_storey_elevation);

for (Double d : this.list_of_storey_elevation) {
System.out.println("after sorting:" + d);
}

if (orderedStories.size() >= 1) {
for (Double key : this.list_of_storey_elevation) {
System.out.println("number of stories " + orderedStories.size());
IfcBuildingStorey floor = orderedStories.get(key);
for (IfcRelContainedInSpatialStructure rel : floor.getContainsElements()) {
for (IfcProduct product : rel.getRelatedElements()) {
if (product instanceof IfcWall) {
IfcWall IfcWallinstance = (IfcWall) product;
out.println(IfcWallinstance.getName());

List<IfcRelDefines> list_defines = IfcWallinstance.getIsDefinedBy();

//out.println("number_of_isDefinedby "+list_defines.size());
for (IfcRelDefines ifc_rel_defines : list_defines) {
if (ifc_rel_defines instanceof IfcRelDefinesByProperties) {
IfcRelDefinesByProperties ifc_rel_defines_by_property = (IfcRelDefinesByProperties) ifc_rel_defines;
IfcPropertySetDefinition ifc_property_set_definition = ifc_rel_defines_by_property.getRelatingPropertyDefinition();
if (ifc_property_set_definition instanceof IfcElementQuantity) {
List<IfcPhysicalQuantity> list_of_quantity = ((IfcElementQuantity) ifc_property_set_definition).getQuantities();
for (IfcPhysicalQuantity ifc_physical_quantity : list_of_quantity) {
if (ifc_physical_quantity instanceof IfcQuantityLength) {
//IfcQuantityLength length=(Ifc)
IfcQuantityLength length = (IfcQuantityLength) ifc_physical_quantity;
//out.println((IfcQuantityLength));
out.println(length.getName() + " " + length.getLengthValue());
}
if (ifc_physical_quantity instanceof IfcQuantityArea) {
IfcQuantityArea area = (IfcQuantityArea) ifc_physical_quantity;
out.println(area.getName() + " " + area.getAreaValue());
}

if (ifc_physical_quantity instanceof IfcQuantityVolume) {
IfcQuantityVolume volume = (IfcQuantityVolume) ifc_physical_quantity;
out.println(volume.getName() + " " + volume.getVolumeValue());
}
if (ifc_physical_quantity instanceof IfcQuantityCount) {
IfcQuantityCount count = (IfcQuantityCount) ifc_physical_quantity;
out.println(count.getName() + " " + count.getCountValue());
}
if (ifc_physical_quantity instanceof IfcQuantityWeight) {
IfcQuantityWeight weight = (IfcQuantityWeight) ifc_physical_quantity;
out.println(weight.getName() + " " + weight.getWeightValue());
}
if (ifc_physical_quantity instanceof IfcQuantityTime) {
IfcQuantityTime time = (IfcQuantityTime) ifc_physical_quantity;
out.println(time.getName() + " " + time.getTimeValue());
}
}
}
}
}
}
}
}
}
}
}
}*/

//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
/*package org.bimserver.querycompiler;

import java.io.PrintWriter;
import org.bimserver.plugins.serializers.IfcModelInterface;
import java.util.*;
import org.bimserver.models.ifc2x3.*;

public class Query implements QueryInterface {

    private IfcModelInterface model;
    private PrintWriter out;

    @Override
    public void query(IfcModelInterface model, PrintWriter out) {
        List<IfcSpace> ifcspaces = model.getAll(IfcSpace.class);
        
        for (IfcSpace IfcSpaceinstance : ifcspaces) {

            out.println("IfcSpace "+IfcSpaceinstance.getName());
            List<IfcRelDefines> list_defines = IfcSpaceinstance.getIsDefinedBy();
            //
            //out.println("number_of_isDefinedby "+list_defines.size());
            for (IfcRelDefines ifc_rel_defines : list_defines) {
                if (ifc_rel_defines instanceof IfcRelDefinesByProperties) {
                    IfcRelDefinesByProperties ifc_rel_defines_by_property = (IfcRelDefinesByProperties) ifc_rel_defines;
                    IfcPropertySetDefinition ifc_property_set_definition = ifc_rel_defines_by_property.getRelatingPropertyDefinition();


                    if (ifc_property_set_definition instanceof IfcElementQuantity) {
                        List<IfcPhysicalQuantity> list_of_quantity = ((IfcElementQuantity) ifc_property_set_definition).getQuantities();
                        for (IfcPhysicalQuantity ifc_physical_quantity : list_of_quantity) {
                            if (ifc_physical_quantity instanceof IfcQuantityLength) {
                                //IfcQuantityLength length=(Ifc)
                                IfcQuantityLength length = (IfcQuantityLength) ifc_physical_quantity;
                                //out.println((IfcQuantityLength));
                                out.println(length.getName() + " " + length.getLengthValue());
                            }
                            if (ifc_physical_quantity instanceof IfcQuantityArea) {
                                IfcQuantityArea area = (IfcQuantityArea) ifc_physical_quantity;
                                out.println(area.getName() + " " + area.getAreaValue());
                            }

                            if (ifc_physical_quantity instanceof IfcQuantityVolume) {
                                IfcQuantityVolume volume = (IfcQuantityVolume) ifc_physical_quantity;
                                out.println(volume.getName() + " " + volume.getVolumeValue());
                            }
                            if (ifc_physical_quantity instanceof IfcQuantityCount) {
                                IfcQuantityCount count = (IfcQuantityCount) ifc_physical_quantity;
                                out.println(count.getName() + " " + count.getCountValue());
                            }
                            if (ifc_physical_quantity instanceof IfcQuantityWeight) {
                                IfcQuantityWeight weight = (IfcQuantityWeight) ifc_physical_quantity;
                                out.println(weight.getName() + " " + weight.getWeightValue());
                            }
                            if (ifc_physical_quantity instanceof IfcQuantityTime) {
                                IfcQuantityTime time = (IfcQuantityTime) ifc_physical_quantity;
                                out.println(time.getName() + " " + time.getTimeValue());
                            }
                        }

                    }


                    if (ifc_property_set_definition instanceof IfcPropertySet) {
                        List<IfcProperty> list_of_property = ((IfcPropertySet) ifc_property_set_definition).getHasProperties();
                        for (IfcProperty property : list_of_property) {
                            if (property instanceof IfcPropertySingleValue) {
                                IfcPropertySingleValue property_single_value = (IfcPropertySingleValue) property;
                                //property_single_value.get
                                //IfcSimpleValue ifc_simple_value=(IfcSimpleValue)property_single_value.getNominalValue();


                                //out.println(((IfcReal)value).getWrappedValue());
                                //out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");

                                IfcValue value = property_single_value.getNominalValue();
                                String result = "IfcDerivedMeasureValue";

                                if (is_IfcSimpleValue(value)) {
                                    result = get_ifcsimplevalue(value);
                                }

                                if (is_IfcMeasureValue(value)) {
                                    result = get_ifcmeasurevalue(value);
                                }

                                //if(property_single_value.getNominalValue() instanceof Ifc)
                                out.println(property_single_value.getName() + " " + result);
                            }
                        }

                    }

                }

            }
            //out.println("IfcRelDefinesByProperties");
        }

    }

public boolean is_IfcSimpleValue(IfcValue value) {

        if (value instanceof IfcSimpleValue) {
            return true;
        }
        return false;

    }

    public boolean is_IfcMeasureValue(IfcValue value) {
        if (value instanceof IfcMeasureValue) {
            return true;
        }
        return false;
    }

    public String get_ifcsimplevalue(IfcValue value) {
        String result = "QQ";

        if (value instanceof IfcInteger) {
            Integer sample = ((IfcInteger) value).getWrappedValue();
            result = sample.toString();
            return result;
        }

        if (value instanceof IfcReal) {
            result = ((IfcReal) value).getWrappedValueAsString();
            return result;
            //result=sample.toString();
        }
        if (value instanceof IfcBoolean) {

            Tristate tristate = ((IfcBoolean) value).getWrappedValue();
            result = tristate.toString();
            return result;

        }
        if (value instanceof IfcIdentifier) {

            result = ((IfcIdentifier) value).getWrappedValue();
            return result;

        }
        if (value instanceof IfcText) {

            result = ((IfcText) value).getWrappedValue();
            return result;

        }
        if (value instanceof IfcLabel) {

            result = ((IfcLabel) value).getWrappedValue();
            return result;

        }
        if (value instanceof IfcLogical) {

            Tristate t = ((IfcLogical) value).getWrappedValue();
            result = t.toString();
            return result;

        }


        return result;
    }

    public String get_ifcmeasurevalue(IfcValue value) {
        String result = "QQ";

        if (value instanceof IfcAreaMeasure) {
            result = ((IfcAreaMeasure) value).getWrappedValueAsString();
            return result;
        }
        if (value instanceof IfcContextDependentMeasure) {
            result = ((IfcContextDependentMeasure) value).getWrappedValueAsString();
            return result;
        }
        //
        if (value instanceof IfcContextDependentMeasure) {
            result = ((IfcContextDependentMeasure) value).getWrappedValueAsString();
            return result;
        }
        if (value instanceof IfcCountMeasure) {
            result = ((IfcCountMeasure) value).getWrappedValueAsString();
            return result;
        }
        if (value instanceof IfcDescriptiveMeasure) {
            result = ((IfcDescriptiveMeasure) value).getWrappedValue();
            return result;
        }
        //
        if (value instanceof IfcElectricCurrentMeasure) {
            result = ((IfcElectricCurrentMeasure) value).getWrappedValueAsString();
            return result;
        }
        if (value instanceof IfcLengthMeasure) {
            result = ((IfcLengthMeasure) value).getWrappedValueAsString();
            return result;
        }

        if (value instanceof IfcLuminousIntensityMeasure) {
            result = ((IfcLuminousIntensityMeasure) value).getWrappedValueAsString();
            return result;
        }
        if (value instanceof IfcMassMeasure) {
            result = ((IfcMassMeasure) value).getWrappedValueAsString();
            return result;
        }
        if (value instanceof IfcNormalisedRatioMeasure) {
            result = ((IfcNormalisedRatioMeasure) value).getWrappedValueAsString();
            return result;
        }
        //
        if (value instanceof IfcNumericMeasure) {
            result = ((IfcNumericMeasure) value).getWrappedValueAsString();
            return result;
        }
        if (value instanceof IfcParameterValue) {
            result = ((IfcParameterValue) value).getWrappedValueAsString();
            return result;
        }

        if (value instanceof IfcPlaneAngleMeasure) {
            result = ((IfcPlaneAngleMeasure) value).getWrappedValueAsString();
            return result;
        }
        if (value instanceof IfcPositiveLengthMeasure) {
            result = ((IfcPositiveLengthMeasure) value).getWrappedValueAsString();
            return result;
        }
        if (value instanceof IfcPositivePlaneAngleMeasure) {
            result = ((IfcPositivePlaneAngleMeasure) value).getWrappedValueAsString();
            return result;
        }
        if (value instanceof IfcPositiveRatioMeasure) {
            result = ((IfcPositiveRatioMeasure) value).getWrappedValueAsString();
            return result;
        }
        if (value instanceof IfcRatioMeasure) {
            result = ((IfcRatioMeasure) value).getWrappedValueAsString();
            return result;
        }
        if (value instanceof IfcSolidAngleMeasure) {
            result = ((IfcSolidAngleMeasure) value).getWrappedValueAsString();
            return result;
        }
        if (value instanceof IfcThermodynamicTemperatureMeasure) {
            result = ((IfcThermodynamicTemperatureMeasure) value).getWrappedValueAsString();
            return result;
        }
        if (value instanceof IfcTimeMeasure) {
            result = ((IfcTimeMeasure) value).getWrappedValueAsString();
            return result;
        }
        if (value instanceof IfcVolumeMeasure) {
            result = ((IfcVolumeMeasure) value).getWrappedValueAsString();
            return result;
        }
        if (value instanceof IfcAmountOfSubstanceMeasure) {
            result = ((IfcAmountOfSubstanceMeasure) value).getWrappedValueAsString();
            return result;
        }

        return result;
    }
}*/
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
/*
package org.bimserver.querycompiler;

import java.io.PrintWriter;
import org.bimserver.plugins.serializers.IfcModelInterface;
import java.util.*;
import org.bimserver.models.ifc2x3.*;

public class Query implements QueryInterface {

    private IfcModelInterface model;
    private PrintWriter out;

    @Override
    public void query(IfcModelInterface model, PrintWriter out) {
        List<IfcFlowSegment> list_of_instance = model.getAll(IfcFlowSegment.class);
        for (IfcFlowSegment instance : list_of_instance) {
            out.println(instance.getName());
        }
    }
}*/