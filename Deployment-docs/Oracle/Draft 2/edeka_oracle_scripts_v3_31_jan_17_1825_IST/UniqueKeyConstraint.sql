--------------------------------------------------------
--  Constraints for Table TextAssetRuntimeTables
--------------------------------------------------------

ALTER TABLE "TextAssetInstanceVersion" ADD CONSTRAINT "TextAssetInstanceVersionU1" UNIQUE ("jobId") ;
ALTER TABLE "TextAssetInstance" ADD CONSTRAINT "TextAssetInstanceU1" UNIQUE ("jobId") ;
--------------------------------------------------------
--  Constraints for Table SupplierRuntimeTables
--------------------------------------------------------

ALTER TABLE "SupplierInstanceVersion" ADD CONSTRAINT "SupplierInstanceVersionU1" UNIQUE ("jobId") ;
ALTER TABLE "SupplierInstance" ADD CONSTRAINT "SupplierInstanceU1" UNIQUE ("jobId") ;

--------------------------------------------------------
--  Constraints for Table SituationRuntimeTables
--------------------------------------------------------
ALTER TABLE "SituationInstanceVersion" ADD CONSTRAINT "SituationInstanceVersionU1" UNIQUE ("jobId") ;
ALTER TABLE "SituationInstance" ADD CONSTRAINT "SituationInstanceU1" UNIQUE ("jobId") ;

--------------------------------------------------------
--  Constraints for Table PromotionRuntimeTables
--------------------------------------------------------
ALTER TABLE "PromotionInstanceVersion" ADD CONSTRAINT "PromotionInstanceVersionU1" UNIQUE ("jobId") ;
ALTER TABLE "PromotionInstance" ADD CONSTRAINT "PromotionInstanceU1" UNIQUE ("jobId") ;

--------------------------------------------------------
--  Constraints for Table PersonaRuntimeTables
--------------------------------------------------------

ALTER TABLE "PersonaInstance" ADD CONSTRAINT "PersonaInstanceU1" UNIQUE ("jobId") ;
ALTER TABLE "PersonaInstanceVersion" ADD CONSTRAINT "PersonaInstanceVersionU1" UNIQUE ("jobId") ;
--------------------------------------------------------
--  Constraints for Table MarketRuntimeTables
--------------------------------------------------------

ALTER TABLE "MarketInstance" ADD CONSTRAINT "MarketInstanceU1" UNIQUE ("jobId") ;
ALTER TABLE "MarketInstanceVersion" ADD CONSTRAINT "MarketInstanceVersionU1" UNIQUE ("jobId") ;

--------------------------------------------------------
--  Constraints for Table CampaignRuntimeTables
--------------------------------------------------------

ALTER TABLE "CampaignInstance" ADD CONSTRAINT "CampaignInstanceU1" UNIQUE ("jobId") ;
ALTER TABLE "CampaignInstanceVersion" ADD CONSTRAINT "CampaignInstanceVersionU1" UNIQUE ("jobId") ;
--------------------------------------------------------
--  Constraints for Table AssetInstanceRuntimeTables
--------------------------------------------------------

ALTER TABLE "AssetInstanceVersion" ADD CONSTRAINT "AssetInstanceVersionU1" UNIQUE ("jobId") ;
ALTER TABLE "AssetInstance" ADD CONSTRAINT "AssetInstanceU1" UNIQUE ("jobId") ;
--------------------------------------------------------
--  Constraints for Table ArticleRuntimeTables
--------------------------------------------------------

ALTER TABLE "ArticleInstanceVersion" ADD CONSTRAINT "ArticleInstanceVersionU1" UNIQUE ("jobId") ;
ALTER TABLE "ArticleInstance" ADD CONSTRAINT "ArticleInstanceU1" UNIQUE ("jobId") ;