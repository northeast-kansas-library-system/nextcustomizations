SP.automatic_item_modification_by_age_configuration.txt

----------

Preference name: automatic_item_modification_by_age_configuration

Type: 

Options: 

----------

Preference value: 



[{"conditions":[{"value":"BURLINGAME","field":"items.homebranch"},{"value":"SWITCH","field":"items.ccode"}],"substitutions":[{"value":"GAME","field":"items.itype"}],"age":"60"},{"age":"60","substitutions":[{"value":"BOOK","field":"items.itype"}],"conditions":[{"field":"items.itype","value":"LOCALHOLD2"}]},{"substitutions":[{"field":"items.itype","value":"BOOK"}],"age":"60","conditions":[{"field":"items.itype","value":"PBBKWALK"}]},{"conditions":[{"field":"items.itype","value":"LOCALHOLD1"}],"substitutions":[{"value":"NVIDEO","field":"items.itype"}],"age":"30"},{"age":"30","substitutions":[{"value":"NVIDEO","field":"items.itype"}],"conditions":[{"value":"NVIDLH","field":"items.itype"}]},{"substitutions":[{"value":"NVIDEO","field":"items.itype"}],"age":"30","conditions":[{"value":"WALKIN1","field":"items.itype"}]},{"age":"30","substitutions":[{"field":"items.itype","value":"NVIDEO"}],"conditions":[{"field":"items.itype","value":"NVIDWALK"}]},{"conditions":[{"value":"MCLOUTH","field":"items.homebranch"},{"value":"NVIDNEW","field":"items.itype"}],"age":"60","substitutions":[{"value":"NVIDEO","field":"items.itype"}]},{"age":"60","substitutions":[{"field":"items.itype","value":"BOOK"}],"conditions":[{"value":"WINCHESTER","field":"items.homebranch"},{"value":"PBBKNEW","field":"items.itype"}]},{"substitutions":[{"field":"items.itype","value":"NVIDEO"}],"age":"60","conditions":[{"value":"WINCHESTER","field":"items.homebranch"},{"value":"NVIDNEW","field":"items.itype"}]},{"conditions":[{"field":"items.homebranch","value":"WINCHESTER"},{"field":"items.itype","value":"NEWAUDIOBOOK"}],"age":"60","substitutions":[{"field":"items.itype","value":"N_AB"}]},{"age":"60","substitutions":[{"field":"items.itype","value":"N_AB"}],"conditions":[{"field":"items.homebranch","value":"WINCHESTER"},{"value":"N_AB_NEW","field":"items.itype"}]},{"age":"1","substitutions":[{"field":"items.itype","value":"NVIDEO"}],"conditions":[{"field":"items.itype","value":"MEDIA"}]},{"conditions":[{"value":"XXX","field":"items.itype"}],"age":"1","substitutions":[{"field":"items.itype","value":"PUNC"}]},{"substitutions":[{"value":"PBBKWALK","field":"items.itype"}],"age":"1","conditions":[{"value":"WALKIN2","field":"items.itype"}]},{"substitutions":[{"value":"P_MAG_N","field":"items.itype"}],"age":"1","conditions":[{"field":"items.itype","value":"PMAGNEW"}]},{"substitutions":[{"field":"items.itype","value":"P_MAG"}],"age":"1","conditions":[{"field":"items.itype","value":"MAGAZINE"}]},{"conditions":[{"value":"NEWAUDIOBOOK","field":"items.itype"}],"substitutions":[{"field":"items.itype","value":"N_AB_NEW"}],"age":"1"},{"age":"1","substitutions":[{"value":"N_AB","field":"items.itype"}],"conditions":[{"value":"AUDIOBOOK","field":"items.itype"}]},{"substitutions":[{"value":"N_AB_M","field":"items.itype"}],"age":"1","conditions":[{"value":"FLPLAYAWAY","field":"items.itype"}]},{"conditions":[{"field":"items.itype","value":"MIFI"}],"substitutions":[{"value":"R_WIFI","field":"items.itype"}],"age":"1"},{"conditions":[{"value":"CHILDRENS","field":"items.location"}],"age":"1","substitutions":[{"field":"items.location","value":"L_JU"},{"field":"items.permanent_location","value":"L_JU"}]},{"age":"1","substitutions":[{"value":"L_JU","field":"items.location"},{"field":"items.permanent_location","value":"L_JU"}],"conditions":[{"field":"items.permanent_location","value":"CHILDRENS"}]},{"age":"1","substitutions":[{"field":"items.permanent_location","value":"L_AD"},{"value":"L_AD","field":"items.location"}],"conditions":[{"value":"ADULT","field":"items.location"}]},{"age":"1","substitutions":[{"field":"items.permanent_location","value":"L_AD"},{"field":"items.location","value":"L_AD"}],"conditions":[{"value":"ADULT","field":"items.permanent_location"}]}]

























