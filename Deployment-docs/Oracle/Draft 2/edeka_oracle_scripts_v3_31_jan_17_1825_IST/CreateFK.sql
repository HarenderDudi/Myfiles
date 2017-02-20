--------------------------------------------------------
--  File created - Sunday-January-29-2017   
--------------------------------------------------------
--------------------------------------------------------
--  Ref Constraints for Table ArticleInstanceVersion
--------------------------------------------------------

  ALTER TABLE "ArticleInstanceVersion" ADD CONSTRAINT "ArticleInstanceVersionF1" FOREIGN KEY ("instanceId")
	  REFERENCES "ArticleInstance" ("id") ON DELETE CASCADE ;
--------------------------------------------------------
--  Ref Constraints for Table AssetInstanceVersion
--------------------------------------------------------

  ALTER TABLE "AssetInstanceVersion" ADD CONSTRAINT "AssetInstanceVersionF2" FOREIGN KEY ("instanceId")
	  REFERENCES "AssetInstance" ("id") ON DELETE CASCADE ;
--------------------------------------------------------
--  Ref Constraints for Table AttributeTag
--------------------------------------------------------

  ALTER TABLE "AttributeTag" ADD CONSTRAINT "AttributeTagF1" FOREIGN KEY ("attributeId")
	  REFERENCES "Attribute" ("id") ON DELETE CASCADE ;
 
  ALTER TABLE "AttributeTag" ADD CONSTRAINT "AttributeTagF2" FOREIGN KEY ("tagId")
	  REFERENCES "Tag" ("id") ON DELETE CASCADE ;
 
  ALTER TABLE "AttributeTag" ADD CONSTRAINT "AttributeTagF3" FOREIGN KEY ("tagValueId")
	  REFERENCES "Tag" ("id") ON DELETE CASCADE ;
--------------------------------------------------------
--  Ref Constraints for Table CalculatedAttributeOperator
--------------------------------------------------------

  ALTER TABLE "CalculatedAttributeOperator" ADD CONSTRAINT "CalculatedAttributeOperatorF1" FOREIGN KEY ("attributeId")
	  REFERENCES "Attribute" ("id") ON DELETE CASCADE ;
 
  ALTER TABLE "CalculatedAttributeOperator" ADD CONSTRAINT "CalculatedAttributeOperatorF2" FOREIGN KEY ("referencedAttributeId")
	  REFERENCES "Attribute" ("id") ON DELETE CASCADE ;
--------------------------------------------------------
--  Ref Constraints for Table CampaignInstanceVersion
--------------------------------------------------------

  ALTER TABLE "CampaignInstanceVersion" ADD CONSTRAINT "CampaignInstanceVersionF1" FOREIGN KEY ("instanceId")
	  REFERENCES "CampaignInstance" ("id") ON DELETE CASCADE ;
--------------------------------------------------------
--  Ref Constraints for Table ComplexAttributeMapping
--------------------------------------------------------

  ALTER TABLE "ComplexAttributeMapping" ADD CONSTRAINT "ComplexAttributeMappingF1" FOREIGN KEY ("complexAttribute_id")
	  REFERENCES "ComplexAttribute" ("id") ON DELETE CASCADE ;
 
  ALTER TABLE "ComplexAttributeMapping" ADD CONSTRAINT "ComplexAttributeMappingF2" FOREIGN KEY ("attribute_id")
	  REFERENCES "Attribute" ("id") ON DELETE CASCADE ;
--------------------------------------------------------
--  Ref Constraints for Table ConcatenatedAttributeList
--------------------------------------------------------

  ALTER TABLE "ConcatenatedAttributeList" ADD CONSTRAINT "ConcatenatedAttributeListF1" FOREIGN KEY ("attributeId")
	  REFERENCES "Attribute" ("id") ON DELETE CASCADE ;
 
  ALTER TABLE "ConcatenatedAttributeList" ADD CONSTRAINT "ConcatenatedAttributeListF2" FOREIGN KEY ("referencedAttributeId")
	  REFERENCES "Attribute" ("id") ON DELETE CASCADE ;
--------------------------------------------------------
--  Ref Constraints for Table ContextEditableProperties
--------------------------------------------------------

  ALTER TABLE "ContextEditableProperties" ADD CONSTRAINT "ContextEditablePropertiesF1" FOREIGN KEY ("context_id")
	  REFERENCES "Context" ("id") ON DELETE CASCADE ;
 
  ALTER TABLE "ContextEditableProperties" ADD CONSTRAINT "ContextEditablePropertiesF2" FOREIGN KEY ("id")
	  REFERENCES "MasterConfigEntity" ("id") ON DELETE CASCADE ;
--------------------------------------------------------
--  Ref Constraints for Table ContextTag
--------------------------------------------------------

  ALTER TABLE "ContextTag" ADD CONSTRAINT "ContextTagF1" FOREIGN KEY ("context_id")
	  REFERENCES "Context" ("id") ON DELETE CASCADE ;
 
  ALTER TABLE "ContextTag" ADD CONSTRAINT "ContextTagF2" FOREIGN KEY ("tag_id")
	  REFERENCES "Tag" ("id") ON DELETE CASCADE ;
 
  ALTER TABLE "ContextTag" ADD CONSTRAINT "ContextTagF3" FOREIGN KEY ("tagValue_id")
	  REFERENCES "Tag" ("id") ON DELETE CASCADE ;
--------------------------------------------------------
--  Ref Constraints for Table DataRuleAttribute
--------------------------------------------------------

  ALTER TABLE "DataRuleAttribute" ADD CONSTRAINT "DataRuleAttributeF1" FOREIGN KEY ("attributeLinkId")
	  REFERENCES "Attribute" ("id") ON DELETE CASCADE ;
 
  ALTER TABLE "DataRuleAttribute" ADD CONSTRAINT "DataRuleAttributeF2" FOREIGN KEY ("ruleListLinkId")
	  REFERENCES "RuleList" ("id") ON DELETE CASCADE ;
 
  ALTER TABLE "DataRuleAttribute" ADD CONSTRAINT "DataRuleAttributeF3" FOREIGN KEY ("entityId")
	  REFERENCES "Attribute" ("id") ON DELETE CASCADE ;
 
  ALTER TABLE "DataRuleAttribute" ADD CONSTRAINT "DataRuleAttributeF4" FOREIGN KEY ("dataRuleId")
	  REFERENCES "DataRule" ("id") ON DELETE CASCADE ;
--------------------------------------------------------
--  Ref Constraints for Table DataRuleRole
--------------------------------------------------------

  ALTER TABLE "DataRuleRole" ADD CONSTRAINT "DataRuleRoleF1" FOREIGN KEY ("entityId")
	  REFERENCES "Role" ("id") ON DELETE CASCADE ;
 
  ALTER TABLE "DataRuleRole" ADD CONSTRAINT "DataRuleRoleF2" FOREIGN KEY ("dataRuleId")
	  REFERENCES "DataRule" ("id") ON DELETE CASCADE ;
--------------------------------------------------------
--  Ref Constraints for Table DataRuleTag
--------------------------------------------------------

  ALTER TABLE "DataRuleTag" ADD CONSTRAINT "DataRuleTagF1" FOREIGN KEY ("entityId")
	  REFERENCES "Tag" ("id") ON DELETE CASCADE ;
 
  ALTER TABLE "DataRuleTag" ADD CONSTRAINT "DataRuleTagF2" FOREIGN KEY ("dataRuleId")
	  REFERENCES "DataRule" ("id") ON DELETE CASCADE ;
--------------------------------------------------------
--  Ref Constraints for Table DataRuleTagValue
--------------------------------------------------------

  ALTER TABLE "DataRuleTagValue" ADD CONSTRAINT "DataRuleTagValueF1" FOREIGN KEY ("id")
	  REFERENCES "Tag" ("id") ON DELETE CASCADE ;
 
  ALTER TABLE "DataRuleTagValue" ADD CONSTRAINT "DataRuleTagValueF2" FOREIGN KEY ("dataRuleTagId")
	  REFERENCES "DataRuleTag" ("ruleId") ON DELETE CASCADE ;
--------------------------------------------------------
--  Ref Constraints for Table ElementDefaultValue
--------------------------------------------------------

  ALTER TABLE "ElementDefaultValue" ADD CONSTRAINT "ElementDefaultValueF1" FOREIGN KEY ("tagId")
	  REFERENCES "Tag" ("id") ON DELETE CASCADE ;
--------------------------------------------------------
--  Ref Constraints for Table Klass
--------------------------------------------------------

  ALTER TABLE "Klass" ADD CONSTRAINT "KlassF1" FOREIGN KEY ("parentId")
	  REFERENCES "Klass" ("id") ON DELETE CASCADE ;
--------------------------------------------------------
--  Ref Constraints for Table KlassContext
--------------------------------------------------------

  ALTER TABLE "KlassContext" ADD CONSTRAINT "KlassContextF1" FOREIGN KEY ("context_id")
	  REFERENCES "Context" ("id") ON DELETE CASCADE ;
 
  ALTER TABLE "KlassContext" ADD CONSTRAINT "KlassContextF2" FOREIGN KEY ("klass_id")
	  REFERENCES "Klass" ("id") ON DELETE CASCADE ;
--------------------------------------------------------
--  Ref Constraints for Table KlassDataRule
--------------------------------------------------------

  ALTER TABLE "KlassDataRule" ADD CONSTRAINT "KlassDataRuleF1" FOREIGN KEY ("dataRuleId")
	  REFERENCES "DataRule" ("id") ON DELETE CASCADE ;
 
  ALTER TABLE "KlassDataRule" ADD CONSTRAINT "KlassDataRuleF2" FOREIGN KEY ("klass_id")
	  REFERENCES "Klass" ("id") ON DELETE CASCADE ;
--------------------------------------------------------
--  Ref Constraints for Table KlassSectionElements
--------------------------------------------------------

  ALTER TABLE "KlassSectionElements" ADD CONSTRAINT "KlassSectionElementsF1" FOREIGN KEY ("sectionId", "klassId")
	  REFERENCES "KlassSections" ("id", "klassId") ON DELETE CASCADE ;
 
  ALTER TABLE "KlassSectionElements" ADD CONSTRAINT "KlassSectionElementsF2" FOREIGN KEY ("pCElementId")
	  REFERENCES "PCElement" ("id") ON DELETE CASCADE ;
--------------------------------------------------------
--  Ref Constraints for Table KlassSections
--------------------------------------------------------

  ALTER TABLE "KlassSections" ADD CONSTRAINT "KlassSectionsF1" FOREIGN KEY ("klassId")
	  REFERENCES "Klass" ("id") ON DELETE CASCADE ;
 
  ALTER TABLE "KlassSections" ADD CONSTRAINT "KlassSectionsF2" FOREIGN KEY ("propertyCollectionId")
	  REFERENCES "PropertyCollection" ("id") ON DELETE CASCADE ;
--------------------------------------------------------
--  Ref Constraints for Table KlassTaxonomyPermissions
--------------------------------------------------------

  ALTER TABLE "KlassTaxonomyPermissions" ADD CONSTRAINT "KlassTaxonomyPermissionsF1" FOREIGN KEY ("roleId")
	  REFERENCES "Role" ("id") ON DELETE CASCADE ;
--------------------------------------------------------
--  Ref Constraints for Table MarketInstanceVersion
--------------------------------------------------------

  ALTER TABLE "MarketInstanceVersion" ADD CONSTRAINT "MarketInstanceVersionF1" FOREIGN KEY ("instanceId")
	  REFERENCES "MarketInstance" ("id") ON DELETE CASCADE ;
--------------------------------------------------------
--  Ref Constraints for Table Normalization
--------------------------------------------------------

  ALTER TABLE "Normalization" ADD CONSTRAINT "NormalizationF1" FOREIGN KEY ("dataRuleId")
	  REFERENCES "DataRule" ("id") ON DELETE CASCADE ;
 
  ALTER TABLE "Normalization" ADD CONSTRAINT "NormalizationF2" FOREIGN KEY ("typeId")
	  REFERENCES "MasterConfigEntity" ("id") ON DELETE CASCADE ;
--------------------------------------------------------
--  Ref Constraints for Table NormalizationTagValue
--------------------------------------------------------

  ALTER TABLE "NormalizationTagValue" ADD CONSTRAINT "NormalizationTagValueF1" FOREIGN KEY ("normalizationId")
	  REFERENCES "Normalization" ("id") ON DELETE CASCADE ;
 
  ALTER TABLE "NormalizationTagValue" ADD CONSTRAINT "NormalizationTagValueF2" FOREIGN KEY ("id")
	  REFERENCES "Tag" ("id") ON DELETE CASCADE ;
--------------------------------------------------------
--  Ref Constraints for Table NormalizationUserMapping
--------------------------------------------------------

  ALTER TABLE "NormalizationUserMapping" ADD CONSTRAINT "NormalizationUserMappingF1" FOREIGN KEY ("normalizationId")
	  REFERENCES "Normalization" ("id") ON DELETE CASCADE ;
 
  ALTER TABLE "NormalizationUserMapping" ADD CONSTRAINT "NormalizationUserMappingF2" FOREIGN KEY ("userId")
	  REFERENCES "User" ("id") ON DELETE CASCADE ;
--------------------------------------------------------
--  Ref Constraints for Table PCElement
--------------------------------------------------------

  ALTER TABLE "PCElement" ADD CONSTRAINT "PCElementF1" FOREIGN KEY ("propertycollection_id")
	  REFERENCES "PropertyCollection" ("id") ON DELETE CASCADE ;
 
  ALTER TABLE "PCElement" ADD CONSTRAINT "PCElementF2" FOREIGN KEY ("typeId")
	  REFERENCES "MasterConfigEntity" ("id") ON DELETE CASCADE ;
--------------------------------------------------------
--  Ref Constraints for Table PersonaInstanceVersion
--------------------------------------------------------

  ALTER TABLE "PersonaInstanceVersion" ADD CONSTRAINT "PersonaInstanceVersionF1" FOREIGN KEY ("instanceId")
	  REFERENCES "PersonaInstance" ("id") ON DELETE CASCADE ;
--------------------------------------------------------
--  Ref Constraints for Table PromotionInstanceVersion
--------------------------------------------------------

  ALTER TABLE "PromotionInstanceVersion" ADD CONSTRAINT "PromotionInstanceVersionF1" FOREIGN KEY ("instanceId")
	  REFERENCES "PromotionInstance" ("id") ON DELETE CASCADE ;
--------------------------------------------------------
--  Ref Constraints for Table PropertyCollectionPermissions
--------------------------------------------------------

  ALTER TABLE "PropertyCollectionPermissions" ADD CONSTRAINT "PropertyCollectionPermissionF1" FOREIGN KEY ("roleId")
	  REFERENCES "Role" ("id") ON DELETE CASCADE ;
 
  ALTER TABLE "PropertyCollectionPermissions" ADD CONSTRAINT "PropertyCollectionPermissionF2" FOREIGN KEY ("propertyCollectionId")
	  REFERENCES "PropertyCollection" ("id") ON DELETE CASCADE ;
--------------------------------------------------------
--  Ref Constraints for Table PropertyPermission
--------------------------------------------------------

  ALTER TABLE "PropertyPermission" ADD CONSTRAINT "PropertyPermissionF1" FOREIGN KEY ("roleId")
	  REFERENCES "Role" ("id") ON DELETE CASCADE ;
 
  ALTER TABLE "PropertyPermission" ADD CONSTRAINT "PropertyPermissionF2" FOREIGN KEY ("propertyId")
	  REFERENCES "MasterConfigEntity" ("id") ON DELETE CASCADE ;
--------------------------------------------------------
--  Ref Constraints for Table RelationshipSide
--------------------------------------------------------

  ALTER TABLE "RelationshipSide" ADD CONSTRAINT "RelationshipSideF1" FOREIGN KEY ("klass_id")
	  REFERENCES "Klass" ("id") ON DELETE CASCADE ;
 
  ALTER TABLE "RelationshipSide" ADD CONSTRAINT "RelationshipSideF2" FOREIGN KEY ("relationship_id")
	  REFERENCES "Relationship" ("id") ON DELETE CASCADE ;
--------------------------------------------------------
--  Ref Constraints for Table RoleEntityMapping
--------------------------------------------------------

  ALTER TABLE "RoleEntityMapping" ADD CONSTRAINT "RoleEntityMappingF1" FOREIGN KEY ("roleId")
	  REFERENCES "Role" ("id") ON DELETE CASCADE ;
 
  ALTER TABLE "RoleEntityMapping" ADD CONSTRAINT "RoleEntityMappingF2" FOREIGN KEY ("entityId")
	  REFERENCES "Entity" ("id") ON DELETE CASCADE ;
--------------------------------------------------------
--  Ref Constraints for Table RoleUserMapping
--------------------------------------------------------

  ALTER TABLE "RoleUserMapping" ADD CONSTRAINT "RoleUserMappingF1" FOREIGN KEY ("roleId")
	  REFERENCES "Role" ("id") ON DELETE CASCADE ;
 
  ALTER TABLE "RoleUserMapping" ADD CONSTRAINT "RoleUserMappingF2" FOREIGN KEY ("userId")
	  REFERENCES "User" ("id") ON DELETE CASCADE ;
--------------------------------------------------------
--  Ref Constraints for Table RuleViolation
--------------------------------------------------------

  ALTER TABLE "RuleViolation" ADD CONSTRAINT "RuleViolationF1" FOREIGN KEY ("dataRuleId")
	  REFERENCES "DataRule" ("id") ON DELETE CASCADE ;
 
  ALTER TABLE "RuleViolation" ADD CONSTRAINT "RuleViolationF2" FOREIGN KEY ("entityId")
	  REFERENCES "MasterConfigEntity" ("id") ON DELETE CASCADE ;
--------------------------------------------------------
--  Ref Constraints for Table SituationInstanceVersion
--------------------------------------------------------

  ALTER TABLE "SituationInstanceVersion" ADD CONSTRAINT "SituationInstanceVersionF1" FOREIGN KEY ("instanceId")
	  REFERENCES "SituationInstance" ("id") ON DELETE CASCADE ;
--------------------------------------------------------
--  Ref Constraints for Table SupplierInstanceVersion
--------------------------------------------------------

  ALTER TABLE "SupplierInstanceVersion" ADD CONSTRAINT "SupplierInstanceVersionF1" FOREIGN KEY ("instanceId")
	  REFERENCES "SupplierInstance" ("id") ON DELETE CASCADE ;
--------------------------------------------------------
--  Ref Constraints for Table Tag
--------------------------------------------------------

  ALTER TABLE "Tag" ADD CONSTRAINT "TagF1" FOREIGN KEY ("tagType")
	  REFERENCES "TagTypeMaster" ("id") ;
 
  ALTER TABLE "Tag" ADD CONSTRAINT "TagF2" FOREIGN KEY ("parentId")
	  REFERENCES "Tag" ("id") ON DELETE CASCADE ;
--------------------------------------------------------
--  Ref Constraints for Table TagTagValue
--------------------------------------------------------

  ALTER TABLE "TagTagValue" ADD CONSTRAINT "TagTagValueF1" FOREIGN KEY ("tagTypeMaster_id")
	  REFERENCES "TagTypeMaster" ("id") ON DELETE CASCADE ;
--------------------------------------------------------
--  Ref Constraints for Table TaxonomyAppliedKlasses
--------------------------------------------------------

  ALTER TABLE "TaxonomyAppliedKlasses" ADD CONSTRAINT "TaxonomyAppliedKlassesF1" FOREIGN KEY ("taxonomyId")
	  REFERENCES "Taxonomy" ("id") ON DELETE CASCADE ;
 
  ALTER TABLE "TaxonomyAppliedKlasses" ADD CONSTRAINT "TaxonomyAppliedKlassesF2" FOREIGN KEY ("klassId")
	  REFERENCES "Klass" ("id") ON DELETE CASCADE ;
--------------------------------------------------------
--  Ref Constraints for Table TaxonomyFilterData
--------------------------------------------------------

  ALTER TABLE "TaxonomyFilterData" ADD CONSTRAINT "TaxonomyFilterDataF1" FOREIGN KEY ("taxonomyId")
	  REFERENCES "Taxonomy" ("id") ON DELETE CASCADE ;
 
  ALTER TABLE "TaxonomyFilterData" ADD CONSTRAINT "TaxonomyFilterDataF2" FOREIGN KEY ("entityId")
	  REFERENCES "MasterConfigEntity" ("id") ON DELETE CASCADE ;
--------------------------------------------------------
--  Ref Constraints for Table TaxonomySectionElements
--------------------------------------------------------

  ALTER TABLE "TaxonomySectionElements" ADD CONSTRAINT "TaxonomySectionElementsF1" FOREIGN KEY ("sectionId", "taxonomyId")
	  REFERENCES "TaxonomySections" ("id", "taxonomyId") ON DELETE CASCADE ;
 
  ALTER TABLE "TaxonomySectionElements" ADD CONSTRAINT "TaxonomySectionElementsF2" FOREIGN KEY ("pCElementId")
	  REFERENCES "PCElement" ("id") ON DELETE CASCADE ;
--------------------------------------------------------
--  Ref Constraints for Table TaxonomySections
--------------------------------------------------------

  ALTER TABLE "TaxonomySections" ADD CONSTRAINT "TaxonomySectionsF1" FOREIGN KEY ("taxonomyId")
	  REFERENCES "Taxonomy" ("id") ON DELETE CASCADE ;
 
  ALTER TABLE "TaxonomySections" ADD CONSTRAINT "TaxonomySectionsF2" FOREIGN KEY ("propertyCollectionId")
	  REFERENCES "PropertyCollection" ("id") ON DELETE CASCADE ;
--------------------------------------------------------
--  Ref Constraints for Table TaxonomySortData
--------------------------------------------------------

  ALTER TABLE "TaxonomySortData" ADD CONSTRAINT "TaxonomySortDataF1" FOREIGN KEY ("taxonomyId")
	  REFERENCES "Taxonomy" ("id") ON DELETE CASCADE ;
 
  ALTER TABLE "TaxonomySortData" ADD CONSTRAINT "TaxonomySortDataF2" FOREIGN KEY ("attributeId")
	  REFERENCES "Attribute" ("id") ON DELETE CASCADE ;
--------------------------------------------------------
--  Ref Constraints for Table TextAssetInstanceVersion
--------------------------------------------------------

  ALTER TABLE "TextAssetInstanceVersion" ADD CONSTRAINT "TextAssetInstanceVersionF1" FOREIGN KEY ("instanceId")
	  REFERENCES "TextAssetInstance" ("id") ON DELETE CASCADE ;
