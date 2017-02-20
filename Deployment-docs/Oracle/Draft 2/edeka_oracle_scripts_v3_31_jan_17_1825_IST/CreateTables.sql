--------------------------------------------------------
--  File created - Sunday-January-29-2017
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table ArticleInstance
--------------------------------------------------------
CREATE TABLE "ArticleInstance"
  (
    "id" VARCHAR2(100),
    "instance" CLOB,
    "createdOn" NUMBER,
	"jobId" VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table ArticleInstancePropVersion
--------------------------------------------------------
CREATE TABLE "ArticleInstancePropVersion"
  (
    "id" VARCHAR2(100),
    "propertyVersion" CLOB
  ) ;
--------------------------------------------------------
--  DDL for Table ArticleInstanceTypeMapping
--------------------------------------------------------
CREATE TABLE "ArticleInstanceTypeMapping"
  (
    "entityId"   VARCHAR2(60),
    "instanceId" VARCHAR2(60)
  ) ;
--------------------------------------------------------
--  DDL for Table ArticleInstanceVersion
--------------------------------------------------------
CREATE TABLE "ArticleInstanceVersion"
  (
    "id"                VARCHAR2(100),
    "instanceId"        VARCHAR2(100),
    "instanceVersionId" NUMBER,
    "instance" CLOB,
    "createdOn" NUMBER,
	"jobId" VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table AssetInstance
--------------------------------------------------------
CREATE TABLE "AssetInstance"
  (
    "id" VARCHAR2(100),
    "instance" CLOB,
    "createdOn" NUMBER,
	"jobId" VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table AssetInstancePropVersion
--------------------------------------------------------
CREATE TABLE "AssetInstancePropVersion"
  (
    "id" VARCHAR2(100),
    "propertyVersion" CLOB
  ) ;
--------------------------------------------------------
--  DDL for Table AssetInstanceTypeMapping
--------------------------------------------------------
CREATE TABLE "AssetInstanceTypeMapping"
  (
    "entityId"   VARCHAR2(60),
    "instanceId" VARCHAR2(60)
  ) ;
--------------------------------------------------------
--  DDL for Table AssetInstanceVersion
--------------------------------------------------------
CREATE TABLE "AssetInstanceVersion"
  (
    "id"                VARCHAR2(100),
    "instanceId"        VARCHAR2(100),
    "instanceVersionId" NUMBER,
    "instance" CLOB,
    "createdOn" NUMBER,
	"jobId" VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table Attribute
--------------------------------------------------------
CREATE TABLE "Attribute"
  (
    "id"                   VARCHAR2(100),
    "lastModifiedBy"       VARCHAR2(20),
    "lastModifiedTime"     DATE,
    "forEditorial"         VARCHAR2(5),
    "forTarget"            VARCHAR2(5),
    "forPim"               VARCHAR2(5),
    "forMam"               VARCHAR2(5),
    "defaultValue"         VARCHAR2(1000),
    "type"                 VARCHAR2(100),
    "isStandard"           VARCHAR2(5),
    "tooltip"              VARCHAR2(1000),
    "isMandatory"          VARCHAR2(5),
    "placeholder"          VARCHAR2(1000),
    "description"          VARCHAR2(1000),
    "icon"                 VARCHAR2(36),
    "label"                VARCHAR2(100),
    "defaultUnit"          VARCHAR2(20),
    "rendererType"         VARCHAR2(50),
    "isSearchable"         VARCHAR2(5),
    "precision"            NUMBER(*,0),
    "numberOfItemsAllowed" NUMBER(*,0),
    "characterLimit"       NUMBER(*,0),
    "validator"            VARCHAR2(2000)
  ) ;
--------------------------------------------------------
--  DDL for Table AttributeTag
--------------------------------------------------------
CREATE TABLE "AttributeTag"
  (
    "attributeId" VARCHAR2(40),
    "tagId"       VARCHAR2(40),
    "tagValueId"  VARCHAR2(40)
  ) ;
--------------------------------------------------------
--  DDL for Table CalculatedAttributeOperator
--------------------------------------------------------
CREATE TABLE "CalculatedAttributeOperator"
  (
    "id"                    VARCHAR2(100),
    "attributeId"           VARCHAR2(100),
    "type"                  VARCHAR2(40),
    "operator"              VARCHAR2(40),
    "order"                 VARCHAR2(1000),
    "value"                 VARCHAR2(1000),
    "referencedAttributeId" VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table CampaignInstance
--------------------------------------------------------
CREATE TABLE "CampaignInstance"
  (
    "id" VARCHAR2(100),
    "instance" CLOB,
    "createdOn" NUMBER,
	"jobId" VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table CampaignInstancePropVersion
--------------------------------------------------------
CREATE TABLE "CampaignInstancePropVersion"
  (
    "id" VARCHAR2(100),
    "propertyVersion" CLOB
  ) ;
--------------------------------------------------------
--  DDL for Table CampaignInstanceTypeMapping
--------------------------------------------------------
CREATE TABLE "CampaignInstanceTypeMapping"
  (
    "entityId"   VARCHAR2(60),
    "instanceId" VARCHAR2(60)
  ) ;
--------------------------------------------------------
--  DDL for Table CampaignInstanceVersion
--------------------------------------------------------
CREATE TABLE "CampaignInstanceVersion"
  (
    "id"                VARCHAR2(100),
    "instanceId"        VARCHAR2(100),
    "instanceVersionId" NUMBER,
    "instance" CLOB,
    "createdOn" NUMBER,
	"jobId" VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table ComplexAttribute
--------------------------------------------------------
CREATE TABLE "ComplexAttribute"
  (
    "id"    VARCHAR2(100),
    "label" VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table ComplexAttributeMapping
--------------------------------------------------------
CREATE TABLE "ComplexAttributeMapping"
  (
    "id"                  VARCHAR2(100),
    "complexAttribute_id" VARCHAR2(100),
    "attribute_id"        VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table ConcatenatedAttributeList
--------------------------------------------------------
CREATE TABLE "ConcatenatedAttributeList"
  (
    "id"                    VARCHAR2(100),
    "attributeId"           VARCHAR2(100),
    "type"                  VARCHAR2(40),
    "operator"              VARCHAR2(40),
    "order"                 VARCHAR2(1000),
    "value"                 VARCHAR2(1000),
    "referencedAttributeId" VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table Context
--------------------------------------------------------
CREATE TABLE "Context"
  (
    "id"    VARCHAR2(100),
    "label" VARCHAR2(100),
    "icon"  VARCHAR2(40)
  ) ;
--------------------------------------------------------
--  DDL for Table ContextEditableProperties
--------------------------------------------------------
CREATE TABLE "ContextEditableProperties"
  (
    "id"         VARCHAR2(100),
    "context_id" VARCHAR2(100),
    "type"       VARCHAR2(20),
    "sequence"   NUMBER(*,0)
  ) ;
--------------------------------------------------------
--  DDL for Table ContextTag
--------------------------------------------------------
CREATE TABLE "ContextTag"
  (
    "context_id"  VARCHAR2(100),
    "tag_id"      VARCHAR2(100),
    "tagValue_id" VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table DataRule
--------------------------------------------------------
CREATE TABLE "DataRule"
  (
    "id"    VARCHAR2(100),
    "label" VARCHAR2(40)
  ) ;
--------------------------------------------------------
--  DDL for Table DataRuleAttribute
--------------------------------------------------------
CREATE TABLE "DataRuleAttribute"
  (
    "id"              VARCHAR2(100),
    "entityId"        VARCHAR2(100),
    "ruleId"          VARCHAR2(100),
    "attributeLinkId" VARCHAR2(100),
    "ruleListLinkId"  VARCHAR2(100),
    "type"            VARCHAR2(50),
    "from"            NUMBER(*,0),
    "to"              NUMBER(*,0),
    "value"           VARCHAR2(100),
    "dataRuleId"      VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table DataRuleRole
--------------------------------------------------------
CREATE TABLE "DataRuleRole"
  (
    "id"         VARCHAR2(100),
    "entityId"   VARCHAR2(100),
    "ruleId"     VARCHAR2(100),
    "type"       VARCHAR2(50),
    "value"      VARCHAR2(100),
    "dataRuleId" VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table DataRuleTag
--------------------------------------------------------
CREATE TABLE "DataRuleTag"
  (
    "id"         VARCHAR2(100),
    "entityId"   VARCHAR2(100),
    "ruleId"     VARCHAR2(100),
    "type"       VARCHAR2(50),
    "dataRuleId" VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table DataRuleTagValue
--------------------------------------------------------
CREATE TABLE "DataRuleTagValue"
  (
    "id"            VARCHAR2(100),
    "from"          NUMBER(*,0),
    "to"            NUMBER(*,0),
    "dataRuleTagId" VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table ElementDefaultValue
--------------------------------------------------------
CREATE TABLE "ElementDefaultValue"
  (
    "id"        VARCHAR2(100),
    "relevance" NUMBER(*,0),
    "tagId"     VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table Entity
--------------------------------------------------------
CREATE TABLE "Entity"
  (
    "id"    VARCHAR2(100),
    "label" VARCHAR2(40)
  ) ;
--------------------------------------------------------
--  DDL for Table Klass
--------------------------------------------------------
CREATE TABLE "Klass"
  (
    "id"                         VARCHAR2(100),
    "icon"                       VARCHAR2(36),
    "lastModifiedby"             VARCHAR2(100),
    "lastModifiedTime"           TIMESTAMP (6) DEFAULT CURRENT_TIMESTAMP,
    "type"                       VARCHAR2(200) DEFAULT 'com.cs.config.interactor.entity.concrete.klass.ProjectKlass',
    "label"                      VARCHAR2(100),
    "isStandard"                 NUMBER(1,0) DEFAULT 0,
    "isEnforcedTaxonomy"         NUMBER(1,0) DEFAULT 0,
    "numberOfVersionsToMaintain" NUMBER(*,0) DEFAULT 1,
    "treeTypeOption"             VARCHAR2(10),
    "isDefaultChild"             NUMBER(1,0) DEFAULT 0,
    "isAbstract"                 NUMBER(1,0) DEFAULT 0,
    "parentId"                   VARCHAR2(100),
    "discriminator"              VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table KlassContext
--------------------------------------------------------
CREATE TABLE "KlassContext"
  (
    "context_id" VARCHAR2(100),
    "klass_id"   VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table KlassDataRule
--------------------------------------------------------
CREATE TABLE "KlassDataRule"
  (
    "dataRuleId" VARCHAR2(100),
    "klass_id"   VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table KlassSectionElements
--------------------------------------------------------
CREATE TABLE "KlassSectionElements"
  (
    "id"            VARCHAR2(100),
    "klassId"       VARCHAR2(100),
    "sectionId"     VARCHAR2(100),
    "isInherited"   NUMBER(1,0) DEFAULT 0,
    "pCElementId"   VARCHAR2(100),
    "isFilterable"  NUMBER(1,0) DEFAULT 0,
    "isSortable"    NUMBER(1,0) DEFAULT 0,
    "isMultiselect" NUMBER(1,0) DEFAULT 0,
    "tagType"       VARCHAR2(50),
    "defaultValue"  VARCHAR2(2000),
    "couplingType"  VARCHAR2(50) DEFAULT 'looselyCoupled',
    "isSkipped"     NUMBER(1,0) DEFAULT 0,
    "isMandatory"   NUMBER(1,0) DEFAULT 0,
    "isChanged"     NUMBER(1,0) DEFAULT 0
  ) ;
--------------------------------------------------------
--  DDL for Table KlassSections
--------------------------------------------------------
CREATE TABLE "KlassSections"
  (
    "id"                   VARCHAR2(100),
    "propertyCollectionId" VARCHAR2(100),
    "sequence"             NUMBER(*,0) DEFAULT 0,
    "klassId"              VARCHAR2(100),
    "isSectionInherited"   NUMBER(1,0) DEFAULT 0,
    "isSequenceInherited"  NUMBER(1,0) DEFAULT 0
  ) ;
--------------------------------------------------------
--  DDL for Table KlassTaxonomyPermissions
--------------------------------------------------------
CREATE TABLE "KlassTaxonomyPermissions"
  (
    "id"        VARCHAR2(100),
    "roleId"    VARCHAR2(100),
    "type"      VARCHAR2(36),
    "entityId"  VARCHAR2(100),
    "canRead"   NUMBER(1,0),
    "canCreate" NUMBER(1,0),
    "canEdit"   NUMBER(1,0),
    "canDelete" NUMBER(1,0)
  ) ;
--------------------------------------------------------
--  DDL for Table MarketInstance
--------------------------------------------------------
CREATE TABLE "MarketInstance"
  (
    "id" VARCHAR2(100),
    "instance" CLOB,
    "createdOn" NUMBER,
	"jobId" VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table MarketInstancePropVersion
--------------------------------------------------------
CREATE TABLE "MarketInstancePropVersion"
  (
    "id" VARCHAR2(100),
    "propertyVersion" CLOB
  ) ;
--------------------------------------------------------
--  DDL for Table MarketInstanceTypeMapping
--------------------------------------------------------
CREATE TABLE "MarketInstanceTypeMapping"
  (
    "entityId"   VARCHAR2(60),
    "instanceId" VARCHAR2(60)
  ) ;
--------------------------------------------------------
--  DDL for Table MarketInstanceVersion
--------------------------------------------------------
CREATE TABLE "MarketInstanceVersion"
  (
    "id"                VARCHAR2(100),
    "instanceId"        VARCHAR2(100),
    "instanceVersionId" NUMBER,
    "instance" CLOB,
    "createdOn" NUMBER,
	"jobId" VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table MasterConfigEntity
--------------------------------------------------------
CREATE TABLE "MasterConfigEntity"
  (
    "id" VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table Normalization
--------------------------------------------------------
CREATE TABLE "Normalization"
  (
    "id"         VARCHAR2(100),
    "dataRuleId" VARCHAR2(100),
    "type"       VARCHAR2(40),
    "typeId"     VARCHAR2(100),
    "values"     VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table NormalizationTagValue
--------------------------------------------------------
CREATE TABLE "NormalizationTagValue"
  (
    "id"              VARCHAR2(100),
    "normalizationId" VARCHAR2(100),
    "innerTagId"      VARCHAR2(100),
    "to"              NUMBER(*,0),
    "from"            NUMBER(*,0)
  ) ;
--------------------------------------------------------
--  DDL for Table NormalizationUserMapping
--------------------------------------------------------
CREATE TABLE "NormalizationUserMapping"
  (
    "normalizationId" VARCHAR2(100),
    "userId"          VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table PCElement
--------------------------------------------------------
CREATE TABLE "PCElement"
  (
    "id"                    VARCHAR2(100),
    "x"                     NUMBER(*,0),
    "y"                     NUMBER(*,0),
    "type"                  VARCHAR2(100),
    "typeId"                VARCHAR2(100),
    "propertycollection_id" VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table PersonaInstance
--------------------------------------------------------
CREATE TABLE "PersonaInstance"
  (
    "id" VARCHAR2(100),
    "instance" CLOB,
    "createdOn" NUMBER,
	"jobId" VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table PersonaInstancePropVersion
--------------------------------------------------------
CREATE TABLE "PersonaInstancePropVersion"
  (
    "id" VARCHAR2(100),
    "propertyVersion" CLOB
  ) ;
--------------------------------------------------------
--  DDL for Table PersonaInstanceTypeMapping
--------------------------------------------------------
CREATE TABLE "PersonaInstanceTypeMapping"
  (
    "entityId"   VARCHAR2(60),
    "instanceId" VARCHAR2(60)
  ) ;
--------------------------------------------------------
--  DDL for Table PersonaInstanceVersion
--------------------------------------------------------
CREATE TABLE "PersonaInstanceVersion"
  (
    "id"                VARCHAR2(100),
    "instanceId"        VARCHAR2(100),
    "instanceVersionId" NUMBER,
    "instance" CLOB,
    "createdOn" NUMBER,
	"jobId" VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table PromotionInstance
--------------------------------------------------------
CREATE TABLE "PromotionInstance"
  (
    "id" VARCHAR2(100),
    "instance" CLOB,
    "createdOn" NUMBER,
	"jobId" VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table PromotionInstancePropVersion
--------------------------------------------------------
CREATE TABLE "PromotionInstancePropVersion"
  (
    "id" VARCHAR2(100),
    "propertyVersion" CLOB
  ) ;
--------------------------------------------------------
--  DDL for Table PromotionInstanceTypeMapping
--------------------------------------------------------
CREATE TABLE "PromotionInstanceTypeMapping"
  (
    "entityId"   VARCHAR2(60),
    "instanceId" VARCHAR2(60)
  ) ;
--------------------------------------------------------
--  DDL for Table PromotionInstanceVersion
--------------------------------------------------------
CREATE TABLE "PromotionInstanceVersion"
  (
    "id"                VARCHAR2(100),
    "instanceId"        VARCHAR2(100),
    "instanceVersionId" NUMBER,
    "instance" CLOB,
    "createdOn" NUMBER,
	"jobId" VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table PropertyCollection
--------------------------------------------------------
CREATE TABLE "PropertyCollection"
  (
    "id"               VARCHAR2(100),
    "label"            VARCHAR2(100),
    "icon"             VARCHAR2(36),
    "rows"             NUMBER(*,0),
    "columns"          NUMBER(*,0),
    "type"             VARCHAR2(100),
    "isForXRay"        NUMBER(1,0) DEFAULT 0,
    "isDefaultForXRay" NUMBER(1,0) DEFAULT 0,
    "isStandard"       NUMBER(1,0) DEFAULT 0
  ) ;
--------------------------------------------------------
--  DDL for Table PropertyCollectionPermissions
--------------------------------------------------------
CREATE TABLE "PropertyCollectionPermissions"
  (
    "id"                   VARCHAR2(100),
    "roleId"               VARCHAR2(100),
    "propertyCollectionId" VARCHAR2(100),
    "isHidden"             NUMBER(1,0),
    "isCollapsed"          NUMBER(1,0),
    "canEdit"              NUMBER(1,0),
    "type"                 VARCHAR2(50)
  ) ;
--------------------------------------------------------
--  DDL for Table PropertyPermission
--------------------------------------------------------
CREATE TABLE "PropertyPermission"
  (
    "id"         VARCHAR2(100),
    "roleId"     VARCHAR2(100),
    "propertyId" VARCHAR2(100),
    "isDisabled" NUMBER(1,0),
    "type"       VARCHAR2(50)
  ) ;
--------------------------------------------------------
--  DDL for Table Relationship
--------------------------------------------------------
CREATE TABLE "Relationship"
  (
    "id"               VARCHAR2(100),
    "lastModifiedBy"   VARCHAR2(100),
    "lastModifiedTime" DATE,
    "placeholder"      VARCHAR2(1000),
    "tooltip"          VARCHAR2(1000),
    "isStandard"       VARCHAR2(2),
    "isMandatory"      VARCHAR2(2),
    "label"            VARCHAR2(100),
    "icon"             VARCHAR2(36),
    "description"      VARCHAR2(1000),
    "type"             VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table RelationshipInstance
--------------------------------------------------------
CREATE TABLE "RelationshipInstance"
  (
    "id" VARCHAR2(100),
    "instance" CLOB,
    "relationshipId"  VARCHAR2(60),
    "side1Id"         VARCHAR2(60),
    "side1InstanceId" VARCHAR2(60),
    "side2Id"         VARCHAR2(60),
    "side2InstanceId" VARCHAR2(60)
  ) ;
--------------------------------------------------------
--  DDL for Table RelationshipInstanceVersion
--------------------------------------------------------
CREATE TABLE "RelationshipInstanceVersion"
  (
    "id" VARCHAR2(100),
    "instance" CLOB
  ) ;
--------------------------------------------------------
--  DDL for Table RelationshipSide
--------------------------------------------------------
CREATE TABLE "RelationshipSide"
  (
    "id"                          VARCHAR2(100),
    "lastModifiedBy"              VARCHAR2(100),
    "lastModifiedTime"            DATE,
    "label"                       VARCHAR2(100),
    "cardinality"                 VARCHAR2(5),
    "sourceCardinality"           VARCHAR2(5),
    "targetRelationshipMappingId" VARCHAR2(100),
    "isVisible"                   NUMBER(1,0),
    "relationship_id"             VARCHAR2(100),
    "correspondingside_id"        VARCHAR2(100),
    "klass_id"                    VARCHAR2(100),
    "side_number"                 VARCHAR2(20)
  ) ;
--------------------------------------------------------
--  DDL for Table Role
--------------------------------------------------------
CREATE TABLE "Role"
  (
    "id"               VARCHAR2(100),
    "versionId"        NUMBER(*,0),
    "lastModifiedBy"   VARCHAR2(200),
    "versionTimestamp" NUMBER(*,0),
    "isMultiselect"    VARCHAR2(5),
    "description"      VARCHAR2(200),
    "placeholder"      VARCHAR2(200),
    "isStandard"       VARCHAR2(5),
    "isMandatory"      VARCHAR2(5),
    "tooltip"          VARCHAR2(200),
    "type"             VARCHAR2(200),
    "icon"             VARCHAR2(40),
    "label"            VARCHAR2(200)
  ) ;
--------------------------------------------------------
--  DDL for Table RoleEntityMapping
--------------------------------------------------------
CREATE TABLE "RoleEntityMapping"
  (
    "id"       VARCHAR2(100),
    "roleId"   VARCHAR2(100),
    "entityId" VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table RoleUserMapping
--------------------------------------------------------
CREATE TABLE "RoleUserMapping"
  (
    "id"     VARCHAR2(100),
    "roleId" VARCHAR2(100),
    "userId" VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table RuleList
--------------------------------------------------------
CREATE TABLE "RuleList"
  (
    "id"    VARCHAR2(100),
    "label" VARCHAR2(40),
    "list"  VARCHAR2(2000)
  ) ;
--------------------------------------------------------
--  DDL for Table RuleViolation
--------------------------------------------------------
CREATE TABLE "RuleViolation"
  (
    "id"          VARCHAR2(100),
    "type"        VARCHAR2(40),
    "color"       VARCHAR2(40),
    "entityId"    VARCHAR2(100),
    "dataRuleId"  VARCHAR2(100),
    "description" VARCHAR2(2000)
  ) ;
--------------------------------------------------------
--  DDL for Table SituationInstance
--------------------------------------------------------
CREATE TABLE "SituationInstance"
  (
    "id" VARCHAR2(100),
    "instance" CLOB,
    "createdOn" NUMBER,
	"jobId" VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table SituationInstancePropVersion
--------------------------------------------------------
CREATE TABLE "SituationInstancePropVersion"
  (
    "id" VARCHAR2(100),
    "propertyVersion" CLOB
  ) ;
--------------------------------------------------------
--  DDL for Table SituationInstanceTypeMapping
--------------------------------------------------------
CREATE TABLE "SituationInstanceTypeMapping"
  (
    "entityId"   VARCHAR2(60),
    "instanceId" VARCHAR2(60)
  ) ;
--------------------------------------------------------
--  DDL for Table SituationInstanceVersion
--------------------------------------------------------
CREATE TABLE "SituationInstanceVersion"
  (
    "id"                VARCHAR2(100),
    "instanceId"        VARCHAR2(100),
    "instanceVersionId" NUMBER,
    "instance" CLOB,
    "createdOn" NUMBER,
	"jobId" VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table SupplierInstance
--------------------------------------------------------
CREATE TABLE "SupplierInstance"
  (
    "id" VARCHAR2(100),
    "instance" CLOB,
    "createdOn" NUMBER,
	"jobId" VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table SupplierInstancePropVersion
--------------------------------------------------------
CREATE TABLE "SupplierInstancePropVersion"
  (
    "id" VARCHAR2(100),
    "propertyVersion" CLOB
  ) ;
--------------------------------------------------------
--  DDL for Table SupplierInstanceTypeMapping
--------------------------------------------------------
CREATE TABLE "SupplierInstanceTypeMapping"
  (
    "entityId"   VARCHAR2(60),
    "instanceId" VARCHAR2(60)
  ) ;
--------------------------------------------------------
--  DDL for Table SupplierInstanceVersion
--------------------------------------------------------
CREATE TABLE "SupplierInstanceVersion"
  (
    "id"                VARCHAR2(100),
    "instanceId"        VARCHAR2(100),
    "instanceVersionId" NUMBER,
    "instance" CLOB,
    "createdOn" NUMBER,
	"jobId" VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table Tag
--------------------------------------------------------
CREATE TABLE "Tag"
  (
    "id"             VARCHAR2(100),
    "lastModifiedBy" VARCHAR2(20),
    "type"           VARCHAR2(100),
    "icon"           VARCHAR2(40),
    "label"          VARCHAR2(100),
    "description"    VARCHAR2(1000),
    "color"          VARCHAR2(15),
    "tooltip"        VARCHAR2(1000),
    "placeholder"    VARCHAR2(1000),
    "tagType"        VARCHAR2(40),
    "klass"          VARCHAR2(1000),
    "shouldDisplay"  NUMBER(1,0),
    "isForRelevance" NUMBER(1,0),
    "isStandard"     NUMBER(1,0),
    "isDimensional"  NUMBER(1,0),
    "isMandatory"    NUMBER(1,0),
    "isMultiselect"  NUMBER(1,0),
    "forPim"         NUMBER(1,0) DEFAULT 1,
    "forMam"         NUMBER(1,0) DEFAULT 1,
    "forTarget"      NUMBER(1,0) DEFAULT 1,
    "forEditorial"   NUMBER(1,0) DEFAULT 1,
    "defaultValueId" VARCHAR2(100),
    "parentId"       VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table TagTagValue
--------------------------------------------------------
CREATE TABLE "TagTagValue"
  (
    "id"               VARCHAR2(100),
    "tagTypeMaster_id" VARCHAR2(100),
    "lastModifiedBy"   VARCHAR2(20),
    "lastModifiedTime" DATE,
    "relevance"        NUMBER(*,0),
    "label"            VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table TagTypeMaster
--------------------------------------------------------
CREATE TABLE "TagTypeMaster"
  (
    "id"               VARCHAR2(100),
    "lastModifiedBy"   VARCHAR2(20),
    "lastModifiedTime" DATE,
    "label"            VARCHAR2(100),
    "isRange"          VARCHAR2(5)
  ) ;
--------------------------------------------------------
--  DDL for Table Taxonomy
--------------------------------------------------------
CREATE TABLE "Taxonomy"
  (
    "id"       VARCHAR2(100),
    "label"    VARCHAR2(100),
    "icon"     VARCHAR2(40),
    "parentId" VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table TaxonomyAppliedKlasses
--------------------------------------------------------
CREATE TABLE "TaxonomyAppliedKlasses"
  (
    "klassId"    VARCHAR2(100),
    "taxonomyId" VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table TaxonomyFilterData
--------------------------------------------------------
CREATE TABLE "TaxonomyFilterData"
  (
    "entityId"   VARCHAR2(100),
    "type"       VARCHAR2(50),
    "taxonomyId" VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table TaxonomySectionElements
--------------------------------------------------------
CREATE TABLE "TaxonomySectionElements"
  (
    "id"            VARCHAR2(100),
    "taxonomyId"    VARCHAR2(100),
    "sectionId"     VARCHAR2(100),
    "isInherited"   NUMBER(1,0) DEFAULT 0,
    "pCElementId"   VARCHAR2(100),
    "isFilterable"  NUMBER(1,0) DEFAULT 0,
    "isSortable"    NUMBER(1,0) DEFAULT 0,
    "isMultiselect" NUMBER(1,0) DEFAULT 0,
    "tagType"       VARCHAR2(50),
    "defaultValue"  VARCHAR2(2000),
    "couplingType"  VARCHAR2(50) DEFAULT 'looselyCoupled',
    "isSkipped"     NUMBER(1,0) DEFAULT 0,
    "isMandatory"   NUMBER(1,0) DEFAULT 0,
    "isChanged"     NUMBER(1,0) DEFAULT 0
  ) ;
--------------------------------------------------------
--  DDL for Table TaxonomySections
--------------------------------------------------------
CREATE TABLE "TaxonomySections"
  (
    "id"                   VARCHAR2(100),
    "propertyCollectionId" VARCHAR2(100),
    "sequence"             NUMBER(*,0) DEFAULT 0,
    "taxonomyId"           VARCHAR2(100),
    "isSectionInherited"   NUMBER(1,0) DEFAULT 0,
    "isSequenceInherited"  NUMBER(1,0) DEFAULT 0
  ) ;
--------------------------------------------------------
--  DDL for Table TaxonomySortData
--------------------------------------------------------
CREATE TABLE "TaxonomySortData"
  (
    "attributeId" VARCHAR2(100),
    "taxonomyId"  VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table TextAssetInstance
--------------------------------------------------------
CREATE TABLE "TextAssetInstance"
  (
    "id" VARCHAR2(100),
    "instance" CLOB,
    "createdOn" NUMBER,
	"jobId" VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table TextAssetInstancePropVersion
--------------------------------------------------------
CREATE TABLE "TextAssetInstancePropVersion"
  (
    "id" VARCHAR2(100),
    "propertyVersion" CLOB
  ) ;
--------------------------------------------------------
--  DDL for Table TextAssetInstanceTypeMapping
--------------------------------------------------------
CREATE TABLE "TextAssetInstanceTypeMapping"
  (
    "entityId"   VARCHAR2(60),
    "instanceId" VARCHAR2(60)
  ) ;
--------------------------------------------------------
--  DDL for Table TextAssetInstanceVersion
--------------------------------------------------------
CREATE TABLE "TextAssetInstanceVersion"
  (
    "id"                VARCHAR2(100),
    "instanceId"        VARCHAR2(100),
    "instanceVersionId" NUMBER,
    "instance" CLOB,
    "createdOn" NUMBER,
	"jobId" VARCHAR2(100)
  ) ;
--------------------------------------------------------
--  DDL for Table User
--------------------------------------------------------
CREATE TABLE "User"
  (
    "id"               VARCHAR2(100),
    "lastModifiedBy"   VARCHAR2(200),
    "icon"             VARCHAR2(40),
    "type"             VARCHAR2(200),
    "label"            VARCHAR2(200),
    "password"         VARCHAR2(200),
    "contact"          VARCHAR2(200),
    "birthDate"        VARCHAR2(50),
    "gender"           VARCHAR2(6),
    "versionId"        NUMBER(*,0),
    "email"            VARCHAR2(200),
    "firstName"        VARCHAR2(200),
    "userName"         VARCHAR2(200),
    "lastName"         VARCHAR2(200),
    "versionTimestamp" NUMBER(*,0)
  ) ;