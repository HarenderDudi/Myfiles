--------------------------------------------------------
--  File created - Sunday-January-29-2017   
--------------------------------------------------------
--------------------------------------------------------
--  Constraints for Table DataRuleTag
--------------------------------------------------------

  ALTER TABLE "DataRuleTag" ADD CONSTRAINT "DataRuleTagPK" PRIMARY KEY ("ruleId") ;
--------------------------------------------------------
--  Constraints for Table KlassSectionElements
--------------------------------------------------------

  ALTER TABLE "KlassSectionElements" ADD CONSTRAINT "KlassSectionElementsPK" PRIMARY KEY ("id", "klassId", "sectionId") ;
--------------------------------------------------------
--  Constraints for Table PromotionInstanceVersion
--------------------------------------------------------

  ALTER TABLE "PromotionInstanceVersion" ADD CONSTRAINT "PromotionInstanceVersionPK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table ContextEditableProperties
--------------------------------------------------------

  ALTER TABLE "ContextEditableProperties" ADD CONSTRAINT "ContextEditablePropertiesPK" PRIMARY KEY ("id", "context_id") ;
--------------------------------------------------------
--  Constraints for Table User
--------------------------------------------------------

  ALTER TABLE "User" ADD CONSTRAINT "UserPK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table TextAssetInstanceVersion
--------------------------------------------------------

  ALTER TABLE "TextAssetInstanceVersion" ADD CONSTRAINT "TextAssetInstanceVersionPK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table TaxonomyFilterData
--------------------------------------------------------

  ALTER TABLE "TaxonomyFilterData" ADD CONSTRAINT "TaxonomyFilterDataPK" PRIMARY KEY ("entityId", "taxonomyId") ;
--------------------------------------------------------
--  Constraints for Table TagTagValue
--------------------------------------------------------

  ALTER TABLE "TagTagValue" ADD CONSTRAINT "TagTagValuePK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table TaxonomyAppliedKlasses
--------------------------------------------------------

  ALTER TABLE "TaxonomyAppliedKlasses" ADD CONSTRAINT "TaxonomyAppliedKlassesPK" PRIMARY KEY ("klassId", "taxonomyId") ;
--------------------------------------------------------
--  Constraints for Table Context
--------------------------------------------------------

  ALTER TABLE "Context" ADD CONSTRAINT "ContextPK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table CampaignInstanceVersion
--------------------------------------------------------

  ALTER TABLE "CampaignInstanceVersion" ADD CONSTRAINT "CampaignInstanceVersionPK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table NormalizationTagValue
--------------------------------------------------------

  ALTER TABLE "NormalizationTagValue" ADD CONSTRAINT "NormalizationTagValuePK" PRIMARY KEY ("normalizationId", "id") ;
--------------------------------------------------------
--  Constraints for Table MarketInstancePropVersion
--------------------------------------------------------

  ALTER TABLE "MarketInstancePropVersion" ADD CONSTRAINT "PK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table RelationshipSide
--------------------------------------------------------

  ALTER TABLE "RelationshipSide" ADD CONSTRAINT "RelationshipSidePK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table MarketInstanceTypeMapping
--------------------------------------------------------

  ALTER TABLE "MarketInstanceTypeMapping" ADD CONSTRAINT "MarketInstanceTypeMappingPK" PRIMARY KEY ("entityId", "instanceId") ;
--------------------------------------------------------
--  Constraints for Table PromotionInstancePropVersion
--------------------------------------------------------

  ALTER TABLE "PromotionInstancePropVersion" ADD CONSTRAINT "PromotionInstancePropVersionPK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table RoleUserMapping
--------------------------------------------------------

  ALTER TABLE "RoleUserMapping" ADD CONSTRAINT "RoleUserMappingPK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table Relationship
--------------------------------------------------------

  ALTER TABLE "Relationship" ADD CONSTRAINT "RelationshipPK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table DataRule
--------------------------------------------------------

  ALTER TABLE "DataRule" ADD CONSTRAINT "DataRulePK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table CampaignInstance
--------------------------------------------------------

  ALTER TABLE "CampaignInstance" ADD CONSTRAINT "CampaignInstancePK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table Tag
--------------------------------------------------------

  ALTER TABLE "Tag" ADD CONSTRAINT "TagPK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table ConcatenatedAttributeList
--------------------------------------------------------

  ALTER TABLE "ConcatenatedAttributeList" ADD CONSTRAINT "ConcatenatedAttributeListPK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table PersonaInstanceVersion
--------------------------------------------------------

  ALTER TABLE "PersonaInstanceVersion" ADD CONSTRAINT "PersonaInstanceVersionPK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table TaxonomySortData
--------------------------------------------------------

  ALTER TABLE "TaxonomySortData" ADD CONSTRAINT "TaxonomySortDataPK" PRIMARY KEY ("attributeId", "taxonomyId") ;
--------------------------------------------------------
--  Constraints for Table Role
--------------------------------------------------------

  ALTER TABLE "Role" ADD CONSTRAINT "RolePK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table AssetInstanceTypeMapping
--------------------------------------------------------

  ALTER TABLE "AssetInstanceTypeMapping" ADD CONSTRAINT "AssetInstanceTypeMappingPK" PRIMARY KEY ("entityId", "instanceId") ;
--------------------------------------------------------
--  Constraints for Table MasterConfigEntity
--------------------------------------------------------

  ALTER TABLE "MasterConfigEntity" ADD CONSTRAINT "MasterConfigEntityPK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table TagTypeMaster
--------------------------------------------------------

  ALTER TABLE "TagTypeMaster" ADD CONSTRAINT "TagTypeMasterPK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table RuleList
--------------------------------------------------------

  ALTER TABLE "RuleList" ADD CONSTRAINT "RuleListPK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table SupplierInstance
--------------------------------------------------------

  ALTER TABLE "SupplierInstance" ADD CONSTRAINT "SupplierInstancePK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table KlassSections
--------------------------------------------------------

  ALTER TABLE "KlassSections" ADD CONSTRAINT "KlassSectionsPK" PRIMARY KEY ("id", "klassId") ;
--------------------------------------------------------
--  Constraints for Table PropertyCollectionPermissions
--------------------------------------------------------

  ALTER TABLE "PropertyCollectionPermissions" ADD CONSTRAINT "PropertyCollectionPermissionPK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table CalculatedAttributeOperator
--------------------------------------------------------

  ALTER TABLE "CalculatedAttributeOperator" ADD CONSTRAINT "CalculatedAttributeOperatorPK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table AssetInstancePropVersion
--------------------------------------------------------

  ALTER TABLE "AssetInstancePropVersion" ADD CONSTRAINT "AssetInstancePropVersionPK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table ElementDefaultValue
--------------------------------------------------------

  ALTER TABLE "ElementDefaultValue" ADD CONSTRAINT "ElementDefaultValuePK" PRIMARY KEY ("id", "tagId") ;
--------------------------------------------------------
--  Constraints for Table TextAssetInstanceTypeMapping
--------------------------------------------------------

  ALTER TABLE "TextAssetInstanceTypeMapping" ADD CONSTRAINT "TextAssetInstanceTypeMappingPK" PRIMARY KEY ("entityId", "instanceId") ;
--------------------------------------------------------
--  Constraints for Table SupplierInstancePropVersion
--------------------------------------------------------

  ALTER TABLE "SupplierInstancePropVersion" ADD CONSTRAINT "SupplierInstancePropVersionPK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table TextAssetInstance
--------------------------------------------------------

  ALTER TABLE "TextAssetInstance" ADD CONSTRAINT "TextAssetInstancePK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table AssetInstance
--------------------------------------------------------

  ALTER TABLE "AssetInstance" ADD CONSTRAINT "AssetInstancePK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table ContextTag
--------------------------------------------------------

  ALTER TABLE "ContextTag" ADD CONSTRAINT "ContextTagPK" PRIMARY KEY ("context_id", "tag_id", "tagValue_id") ;
--------------------------------------------------------
--  Constraints for Table ArticleInstancePropVersion
--------------------------------------------------------

  ALTER TABLE "ArticleInstancePropVersion" ADD CONSTRAINT "ARTICLEINSTANCEPROPVERSIONPK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table Klass
--------------------------------------------------------

  ALTER TABLE "Klass" ADD CONSTRAINT "KlassPK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table Normalization
--------------------------------------------------------

  ALTER TABLE "Normalization" ADD CONSTRAINT "NormalizationPK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table PersonaInstance
--------------------------------------------------------

  ALTER TABLE "PersonaInstance" ADD CONSTRAINT "PersonaInstancePK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table RuleViolation
--------------------------------------------------------

  ALTER TABLE "RuleViolation" ADD CONSTRAINT "RuleViolationPK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table ComplexAttribute
--------------------------------------------------------

  ALTER TABLE "ComplexAttribute" ADD CONSTRAINT "ComplexAttributePK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table SituationInstance
--------------------------------------------------------

  ALTER TABLE "SituationInstance" ADD CONSTRAINT "SituationInstancePK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table Taxonomy
--------------------------------------------------------

  ALTER TABLE "Taxonomy" ADD CONSTRAINT "TaxonomyPK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table RelationshipInstance
--------------------------------------------------------

  ALTER TABLE "RelationshipInstance" ADD CONSTRAINT "RelationshipInstancePK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table ArticleInstanceTypeMapping
--------------------------------------------------------

  ALTER TABLE "ArticleInstanceTypeMapping" ADD CONSTRAINT "ArticleInstanceTypeMappingPK" PRIMARY KEY ("entityId", "instanceId") ;
--------------------------------------------------------
--  Constraints for Table TaxonomySectionElements
--------------------------------------------------------

  ALTER TABLE "TaxonomySectionElements" ADD CONSTRAINT "TaxonomySectionElementsPK" PRIMARY KEY ("id", "taxonomyId", "sectionId") ;
--------------------------------------------------------
--  Constraints for Table PromotionInstance
--------------------------------------------------------

  ALTER TABLE "PromotionInstance" ADD CONSTRAINT "PromotionInstancePK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table MarketInstanceVersion
--------------------------------------------------------

  ALTER TABLE "MarketInstanceVersion" ADD CONSTRAINT "MarketInstanceVersionPK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table SupplierInstanceTypeMapping
--------------------------------------------------------

  ALTER TABLE "SupplierInstanceTypeMapping" ADD CONSTRAINT "SupplierInstanceTypeMappingPK" PRIMARY KEY ("entityId", "instanceId") ;
--------------------------------------------------------
--  Constraints for Table KlassTaxonomyPermissions
--------------------------------------------------------

  ALTER TABLE "KlassTaxonomyPermissions" ADD CONSTRAINT "KlassTaxonomyPermissionsPK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table RoleEntityMapping
--------------------------------------------------------

  ALTER TABLE "RoleEntityMapping" ADD CONSTRAINT "RoleEntityMappingPK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table DataRuleTagValue
--------------------------------------------------------

  ALTER TABLE "DataRuleTagValue" ADD CONSTRAINT "DataRuleTagValuePK" PRIMARY KEY ("id", "dataRuleTagId") ;
--------------------------------------------------------
--  Constraints for Table SituationInstanceVersion
--------------------------------------------------------

  ALTER TABLE "SituationInstanceVersion" ADD CONSTRAINT "SituationInstanceVersionPK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table ArticleInstanceVersion
--------------------------------------------------------

  ALTER TABLE "ArticleInstanceVersion" ADD CONSTRAINT "ArticleInstanceVersionPK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table Attribute
--------------------------------------------------------

  ALTER TABLE "Attribute" ADD CONSTRAINT "AttributePK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table PromotionInstanceTypeMapping
--------------------------------------------------------

  ALTER TABLE "PromotionInstanceTypeMapping" ADD CONSTRAINT "PromotionInstanceTypeMappingPK" PRIMARY KEY ("entityId", "instanceId") ;
--------------------------------------------------------
--  Constraints for Table MarketInstance
--------------------------------------------------------

  ALTER TABLE "MarketInstance" ADD CONSTRAINT "MarketInstancePK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table DataRuleAttribute
--------------------------------------------------------

  ALTER TABLE "DataRuleAttribute" ADD CONSTRAINT "DataRuleAttributePK" PRIMARY KEY ("ruleId") ;
--------------------------------------------------------
--  Constraints for Table CampaignInstanceTypeMapping
--------------------------------------------------------

  ALTER TABLE "CampaignInstanceTypeMapping" ADD CONSTRAINT "CampaignInstanceTypeMappingPK" PRIMARY KEY ("entityId", "instanceId") ;
--------------------------------------------------------
--  Constraints for Table PersonaInstancePropVersion
--------------------------------------------------------

  ALTER TABLE "PersonaInstancePropVersion" ADD CONSTRAINT "PersonaInstancePropVersionPK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table PCElement
--------------------------------------------------------

  ALTER TABLE "PCElement" ADD CONSTRAINT "PCElementPK" PRIMARY KEY ("id") ;
 
  ALTER TABLE "PCElement" ADD UNIQUE ("x", "y", "propertycollection_id") ;
--------------------------------------------------------
--  Constraints for Table PropertyCollection
--------------------------------------------------------

  ALTER TABLE "PropertyCollection" ADD CONSTRAINT "PropertyCollectionPK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table CampaignInstancePropVersion
--------------------------------------------------------

  ALTER TABLE "CampaignInstancePropVersion" ADD CONSTRAINT "CampaignInstancePropVersionPK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table AssetInstanceVersion
--------------------------------------------------------

  ALTER TABLE "AssetInstanceVersion" ADD CONSTRAINT "AssetInstanceVersionPK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table SituationInstancePropVersion
--------------------------------------------------------

  ALTER TABLE "SituationInstancePropVersion" ADD CONSTRAINT "SituationInstancePropVersionPK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table AttributeTag
--------------------------------------------------------

  ALTER TABLE "AttributeTag" ADD CONSTRAINT "AttributeTagPK" PRIMARY KEY ("attributeId", "tagId", "tagValueId") ;
--------------------------------------------------------
--  Constraints for Table DataRuleRole
--------------------------------------------------------

  ALTER TABLE "DataRuleRole" ADD CONSTRAINT "DataRuleRolePK" PRIMARY KEY ("ruleId") ;
--------------------------------------------------------
--  Constraints for Table ArticleInstance
--------------------------------------------------------

  ALTER TABLE "ArticleInstance" ADD CONSTRAINT "ArticleInstancePK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table SupplierInstanceVersion
--------------------------------------------------------

  ALTER TABLE "SupplierInstanceVersion" ADD CONSTRAINT "SupplierInstanceVersionPK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table PropertyPermission
--------------------------------------------------------

  ALTER TABLE "PropertyPermission" ADD CONSTRAINT "PropertyPermissionPK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table TaxonomySections
--------------------------------------------------------

  ALTER TABLE "TaxonomySections" ADD CONSTRAINT "TaxonomySectionsPK" PRIMARY KEY ("id", "taxonomyId") ;
--------------------------------------------------------
--  Constraints for Table ComplexAttributeMapping
--------------------------------------------------------

  ALTER TABLE "ComplexAttributeMapping" ADD CONSTRAINT "ComplexAttributeMappingPK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table PersonaInstanceTypeMapping
--------------------------------------------------------

  ALTER TABLE "PersonaInstanceTypeMapping" ADD CONSTRAINT "PersonaInstanceTypeMappingPK" PRIMARY KEY ("entityId", "instanceId") ;
--------------------------------------------------------
--  Constraints for Table Entity
--------------------------------------------------------

  ALTER TABLE "Entity" ADD CONSTRAINT "EntityPK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table SituationInstanceTypeMapping
--------------------------------------------------------

  ALTER TABLE "SituationInstanceTypeMapping" ADD CONSTRAINT "SituationInstanceTypeMappingPK" PRIMARY KEY ("entityId", "instanceId") ;
--------------------------------------------------------
--  Constraints for Table RelationshipInstanceVersion
--------------------------------------------------------

  ALTER TABLE "RelationshipInstanceVersion" ADD CONSTRAINT "RelationshipInstanceVersionPK" PRIMARY KEY ("id") ;
--------------------------------------------------------
--  Constraints for Table NormalizationUserMapping
--------------------------------------------------------

  ALTER TABLE "NormalizationUserMapping" ADD CONSTRAINT "NormalizationUserMappingPK" PRIMARY KEY ("normalizationId", "userId") ;
--------------------------------------------------------
--  Constraints for Table TextAssetInstancePropVersion
--------------------------------------------------------

  ALTER TABLE "TextAssetInstancePropVersion" ADD CONSTRAINT "TextAssetInstancePropVersionPK" PRIMARY KEY ("id") ;
