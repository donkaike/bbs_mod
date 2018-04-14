package com.rafacost3d.bbs_mod.integration.jei;
import com.rafacost3d.bbs_mod.BBSMod;
import com.rafacost3d.bbs_mod.init.BlocksInit;
import com.rafacost3d.bbs_mod.integration.jei.microbrewer.MicroBrewerRecipeCategory;
import com.rafacost3d.bbs_mod.integration.jei.microbrewer.MicroBrewerRecipeMaker;
import com.rafacost3d.bbs_mod.objects.blocks.machines.MicroBrewer.MicroBrewerContainer;
import com.rafacost3d.bbs_mod.objects.blocks.machines.MicroBrewer.MicroBrewerGui;
import com.rafacost3d.bbs_mod.objects.crops.CropRegistry;
import mezz.jei.api.*;
import mezz.jei.api.ingredients.IIngredientBlacklist;
import mezz.jei.api.ingredients.IIngredientRegistry;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mezz.jei.api.recipe.transfer.IRecipeTransferRegistry;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

@mezz.jei.api.JEIPlugin
public class JeiBBSPlugin extends BlankModPlugin {

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry){
        final IJeiHelpers helpers = registry.getJeiHelpers();
        final IGuiHelper gui = helpers.getGuiHelper();
        registry.addRecipeCategories(new MicroBrewerRecipeCategory(gui));
    }


    @Override
    public void register(@Nonnull IModRegistry registry) {


        BBSMod.logger.info(">> Loading Beer Brewing Simulator Jei Plugin");
        IIngredientBlacklist blacklist = registry.getJeiHelpers().getIngredientBlacklist();
        blacklist.addIngredientToBlacklist(new ItemStack(CropRegistry.getSeed("maltpilsen")));
        blacklist.addIngredientToBlacklist(new ItemStack(CropRegistry.getSeed("maltmunich")));
        blacklist.addIngredientToBlacklist(new ItemStack(CropRegistry.getSeed("maltamber")));
        blacklist.addIngredientToBlacklist(new ItemStack(CropRegistry.getSeed("maltdark")));

        final IIngredientRegistry ingredientRegistry = registry.getIngredientRegistry();
        final IJeiHelpers jeiHelpers = registry.getJeiHelpers();
        //IRecipeTransferRegistry recipeTransfer = registry.getRecipeTransferRegistry();

        registry.addRecipeCategoryCraftingItem(new ItemStack(BlocksInit.microBrewerBlock), RecipeCategories.MICRO);
        registry.addRecipes(MicroBrewerRecipeMaker.getRecipes(jeiHelpers), RecipeCategories.MICRO);
        registry.addRecipeClickArea(MicroBrewerGui.class, 44, 33, 24, 17, RecipeCategories.MICRO);
        //recipeTransfer.addRecipeTransferHandler(MicroBrewerContainer.class, RecipeCategories.MICRO, 0, 1, 3, 36);



        registry.addDescription(new ItemStack(CropRegistry.getFood("admiral")), "Hop Type: " + "Bittering", "Alpha Acid: " + "14.5", "Description: \n" + "Citrus, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("ahtanum")), "Hop Type: " + "Aroma", "Alpha Acid: " + "5.5", "Description: \n" + "Earthy, Floral, Citrus");
        registry.addDescription(new ItemStack(CropRegistry.getFood("amarillo")), "Hop Type: " + "Aroma", "Alpha Acid: " + "8.6", "Description: \n" + "Floral, Citrus");
        registry.addDescription(new ItemStack(CropRegistry.getFood("aquila")), "Hop Type: " + "Aroma", "Alpha Acid: " + "7", "Description: \n" + "Earthy, Fruity");
        registry.addDescription(new ItemStack(CropRegistry.getFood("aramis")), "Hop Type: " + "Aroma", "Alpha Acid: " + "8.1", "Description: \n" + "Earthy, Citrus, Spicy, Herbal, Green");
        registry.addDescription(new ItemStack(CropRegistry.getFood("aurora")), "Hop Type: " + "Dual", "Alpha Acid: " + "10", "Description: \n" + "Earthy, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("banner")), "Hop Type: " + "Bittering", "Alpha Acid: " + "10", "Description: \n" + "Fruity, Floral");
        registry.addDescription(new ItemStack(CropRegistry.getFood("bcgolding")), "Hop Type: " + "Aroma", "Alpha Acid: " + "5", "Description: \n" + "Spicy, Earthy");
        registry.addDescription(new ItemStack(CropRegistry.getFood("bittergold")), "Hop Type: " + "Dual", "Alpha Acid: " + "13", "Description: \n" + "Grassy, Stone Fruit, Tropical Fruit");
        registry.addDescription(new ItemStack(CropRegistry.getFood("blanc")), "Hop Type: " + "Aroma", "Alpha Acid: " + "10.5", "Description: \n" + "Flora, Citrus, Fruity, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("bobek")), "Hop Type: " + "Aroma", "Alpha Acid: " + "5", "Description: \n" + "Floral, Pine");
        registry.addDescription(new ItemStack(CropRegistry.getFood("bramlingcross")), "Hop Type: " + "Dual", "Alpha Acid: " + "6.5", "Description: \n" + "Spicy, Fruity");
        registry.addDescription(new ItemStack(CropRegistry.getFood("bravo")), "Hop Type: " + "Bittering", "Alpha Acid: " + "16.5", "Description: \n" + "Floral, Fruity");
        registry.addDescription(new ItemStack(CropRegistry.getFood("brewersgoldgermany")), "Hop Type: " + "Aroma", "Alpha Acid: " + "5.5", "Description: \n" + "Spicy, Fruity");
        registry.addDescription(new ItemStack(CropRegistry.getFood("brewersgoldusa")), "Hop Type: " + "Bittering", "Alpha Acid: " + "9.5", "Description: \n" + "Spicy, Fruity");
        registry.addDescription(new ItemStack(CropRegistry.getFood("bullion")), "Hop Type: " + "Bittering", "Alpha Acid: " + "7.5", "Description: \n" + "Spicy, Fruity");
        registry.addDescription(new ItemStack(CropRegistry.getFood("cascade")), "Hop Type: " + "Aroma", "Alpha Acid: " + "7", "Description: \n" + "Floral, Citrus, Spicy");
        registry.addDescription(new ItemStack(CropRegistry.getFood("celeia")), "Hop Type: " + "Dual", "Alpha Acid: " + "4.5", "Description: \n" + "Earthy, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("centennial")), "Hop Type: " + "Dual", "Alpha Acid: " + "7.8", "Description: \n" + "Floral, Citrus");
        registry.addDescription(new ItemStack(CropRegistry.getFood("challenger")), "Hop Type: " + "Dual", "Alpha Acid: " + "8.5", "Description: \n" + "Fruity, Herbal, Cedar");
        registry.addDescription(new ItemStack(CropRegistry.getFood("chelan")), "Hop Type: " + "Bittering", "Alpha Acid: " + "13", "Description: \n" + "Citrus, Stone Fruit, Fruity");
        registry.addDescription(new ItemStack(CropRegistry.getFood("chinook")), "Hop Type: " + "Dual", "Alpha Acid: " + "13", "Description: \n" + "Citrus, Spicy, Pine");
        registry.addDescription(new ItemStack(CropRegistry.getFood("citra")), "Hop Type: " + "Aroma", "Alpha Acid: " + "11", "Description: \n" + "Citrus, Tropical Fruit");
        registry.addDescription(new ItemStack(CropRegistry.getFood("cluster")), "Hop Type: " + "Dual", "Alpha Acid: " + "7.5", "Description: \n" + "Earthy, Floral, Fruity");
        registry.addDescription(new ItemStack(CropRegistry.getFood("columbus")), "Hop Type: " + "Bittering", "Alpha Acid: " + "4", "Description: \n" + "Earthy, Citrus, Spicy");
        registry.addDescription(new ItemStack(CropRegistry.getFood("comet")), "Hop Type: " + "Bittering", "Alpha Acid: " + "9", "Description: \n" + "Grassy, Citrus");
        registry.addDescription(new ItemStack(CropRegistry.getFood("crystal")), "Hop Type: " + "Aroma", "Alpha Acid: " + "4.5", "Description: \n" + "Earthy, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("drrudi")), "Hop Type: " + "Dual", "Alpha Acid: " + "11", "Description: \n" + "Pine, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("eastkentgolding")), "Hop Type: " + "Dual", "Alpha Acid: " + "5", "Description: \n" + "Citrus, Spicy");
        registry.addDescription(new ItemStack(CropRegistry.getFood("ekuanot")), "Hop Type: " + "Aroma", "Alpha Acid: " + "14", "Description: \n" + "Citrus, Tropical Fruit, Fruity, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("ella")), "Hop Type: " + "Dual", "Alpha Acid: " + "14.8", "Description: \n" + "Floral, Spicy");
        registry.addDescription(new ItemStack(CropRegistry.getFood("eroica")), "Hop Type: " + "Bittering", "Alpha Acid: " + "12", "Description: \n" + "Fruity");
        registry.addDescription(new ItemStack(CropRegistry.getFood("falconersflight")), "Hop Type: " + "Aroma", "Alpha Acid: " + "10.8", "Description: \n" + "Floral, Citrus, Tropical Fruit");
        registry.addDescription(new ItemStack(CropRegistry.getFood("firstgold")), "Hop Type: " + "Dual", "Alpha Acid: " + "7.5", "Description: \n" + "Floral, Citrus, Stone Fruit, Fruity");
        registry.addDescription(new ItemStack(CropRegistry.getFood("fuggleuk")), "Hop Type: " + "Aroma", "Alpha Acid: " + "4.5", "Description: \n" + "Earthy");
        registry.addDescription(new ItemStack(CropRegistry.getFood("galaxy")), "Hop Type: " + "Dual", "Alpha Acid: " + "13.8", "Description: \n" + "Fruity");
        registry.addDescription(new ItemStack(CropRegistry.getFood("galena")), "Hop Type: " + "Bittering", "Alpha Acid: " + "13", "Description: \n" + "Citrus, Spicy, Fruity");
        registry.addDescription(new ItemStack(CropRegistry.getFood("glacier")), "Hop Type: " + "Dual", "Alpha Acid: " + "5.5", "Description: \n" + "Fruity, Cedar");
        registry.addDescription(new ItemStack(CropRegistry.getFood("gold")), "Hop Type: " + "Aroma", "Alpha Acid: " + "5", "Description: \n" + "Earthy, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("goldinguk")), "Hop Type: " + "Aroma", "Alpha Acid: " + "5", "Description: \n" + "Floral, Citrus");
        registry.addDescription(new ItemStack(CropRegistry.getFood("goldingusa")), "Hop Type: " + "Aroma", "Alpha Acid: " + "4.5", "Description: \n" + "Floral, Fruity, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("greenbullet")), "Hop Type: " + "Dual", "Alpha Acid: " + "12.5", "Description: \n" + "Floral, Spicy, Fruity, Pine");
        registry.addDescription(new ItemStack(CropRegistry.getFood("hallertaumittelfruh")), "Hop Type: " + "Aroma", "Alpha Acid: " + "3.75", "Description: \n" + "Floral, Citrus, Spicy");
        registry.addDescription(new ItemStack(CropRegistry.getFood("hallertauusa")), "Hop Type: " + "Aroma", "Alpha Acid: " + "5", "Description: \n" + "Earthy, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("hbc431experimental")), "Hop Type: " + "Dual", "Alpha Acid: " + "15", "Description: \n" + "Floral, Citrus, Spicy, Tropical Fruit, Fruity, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("hbc438experimental")), "Hop Type: " + "Dual", "Alpha Acid: " + "13.7", "Description: \n" + "Citrus, Stone Fruit, Tropical Fruit, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("hbc472experimental")), "Hop Type: " + "Aroma", "Alpha Acid: " + "10", "Description: \n" + "Floral, Tropical Fruit, Cedar");
        registry.addDescription(new ItemStack(CropRegistry.getFood("hbc682experimental")), "Hop Type: " + "Bittering", "Alpha Acid: " + "19.5", "Description: \n" + "Earthy, Spicy, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("helga")), "Hop Type: " + "Dual", "Alpha Acid: " + "6", "Description: \n" + "Earthy, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("herald")), "Hop Type: " + "Bittering", "Alpha Acid: " + "12", "Description: \n" + "Fruity");
        registry.addDescription(new ItemStack(CropRegistry.getFood("herkules")), "Hop Type: " + "Bittering", "Alpha Acid: " + "14.5", "Description: \n" + "Citrus, Fruity");
        registry.addDescription(new ItemStack(CropRegistry.getFood("hersbrucker")), "Hop Type: " + "Aroma", "Alpha Acid: " + "3", "Description: \n" + "Earthy, Citrus");
        registry.addDescription(new ItemStack(CropRegistry.getFood("horizon")), "Hop Type: " + "Dual", "Alpha Acid: " + "10.5", "Description: \n" + "Floral, Spicy");
        registry.addDescription(new ItemStack(CropRegistry.getFood("huellmelon")), "Hop Type: " + "Aroma", "Alpha Acid: " + "7", "Description: \n" + "Fruity");
        registry.addDescription(new ItemStack(CropRegistry.getFood("hullerbitterer")), "Hop Type: " + "Aroma", "Alpha Acid: " + "5.75", "Description: \n" + "Earthy, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("kohatu")), "Hop Type: " + "Dual", "Alpha Acid: " + "6.5", "Description: \n" + "Tropical Fruit");
        registry.addDescription(new ItemStack(CropRegistry.getFood("liberty")), "Hop Type: " + "Aroma", "Alpha Acid: " + "4", "Description: \n" + "Floral, Citrus, Spicy");
        registry.addDescription(new ItemStack(CropRegistry.getFood("loral")), "Hop Type: " + "Dual", "Alpha Acid: " + "11.8", "Description: \n" + "Floral, Citrus, Fruity, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("lubelska")), "Hop Type: " + "Aroma", "Alpha Acid: " + "4.5", "Description: \n" + "Spicy, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("magnum")), "Hop Type: " + "Bittering", "Alpha Acid: " + "15", "Description: \n" + "Spicy, Fruity");
        registry.addDescription(new ItemStack(CropRegistry.getFood("mandarinabavaria")), "Hop Type: " + "Aroma", "Alpha Acid: " + "8.5", "Description: \n" + "Citrus, Fruity");
        registry.addDescription(new ItemStack(CropRegistry.getFood("merkur")), "Hop Type: " + "Dual", "Alpha Acid: " + "13", "Description: \n" + "Tropical Fruit, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("millenium")), "Hop Type: " + "Bittering", "Alpha Acid: " + "17", "Description: \n" + "Floral, Fruity, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("mosaic")), "Hop Type: " + "Aroma", "Alpha Acid: " + "12", "Description: \n" + "Earthy, Floral, Fruity");
        registry.addDescription(new ItemStack(CropRegistry.getFood("motueka")), "Hop Type: " + "Aroma", "Alpha Acid: " + "7", "Description: \n" + "Citrus, Tropical Fruit");
        registry.addDescription(new ItemStack(CropRegistry.getFood("mounthood")), "Hop Type: " + "Aroma", "Alpha Acid: " + "4.8", "Description: \n" + "Spicy, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("mountrainier")), "Hop Type: " + "Dual", "Alpha Acid: " + "6.2", "Description: \n" + "Floral, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("nelsonsauvin")), "Hop Type: " + "Dual", "Alpha Acid: " + "12.5", "Description: \n" + "Fruity");
        registry.addDescription(new ItemStack(CropRegistry.getFood("newport")), "Hop Type: " + "Bittering", "Alpha Acid: " + "11", "Description: \n" + "Earthy, Citrus");
        registry.addDescription(new ItemStack(CropRegistry.getFood("northdown")), "Hop Type: " + "Dual", "Alpha Acid: " + "8.6", "Description: \n" + "Floral, Spicy, Fruity, Pine");
        registry.addDescription(new ItemStack(CropRegistry.getFood("northernbrewer")), "Hop Type: " + "Dual", "Alpha Acid: " + "7.8", "Description: \n" + "Grassy, Pine, Herbal, Cedar");
        registry.addDescription(new ItemStack(CropRegistry.getFood("nugget")), "Hop Type: " + "Bittering", "Alpha Acid: " + "14", "Description: \n" + "Earthy, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("olympic")), "Hop Type: " + "Aroma", "Alpha Acid: " + "12", "Description: \n" + "Fruity");
        registry.addDescription(new ItemStack(CropRegistry.getFood("omega")), "Hop Type: " + "Aroma", "Alpha Acid: " + "10", "Description: \n" + "Fruity, Floral");
        registry.addDescription(new ItemStack(CropRegistry.getFood("opal")), "Hop Type: " + "Dual", "Alpha Acid: " + "6.5", "Description: \n" + "Floral, Citrus, Spicy, Fruity, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("orion")), "Hop Type: " + "Aroma", "Alpha Acid: " + "7", "Description: \n" + "Fruity");
        registry.addDescription(new ItemStack(CropRegistry.getFood("pacifica")), "Hop Type: " + "Aroma", "Alpha Acid: " + "5.5", "Description: \n" + "Floral, Citrus");
        registry.addDescription(new ItemStack(CropRegistry.getFood("pacificgem")), "Hop Type: " + "Bittering", "Alpha Acid: " + "14", "Description: \n" + "Earthy, Floral, Spicy, Fruity");
        registry.addDescription(new ItemStack(CropRegistry.getFood("pacificjade")), "Hop Type: " + "Dual", "Alpha Acid: " + "13", "Description: \n" + "Citrus, Spicy, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("palisade")), "Hop Type: " + "Aroma", "Alpha Acid: " + "8", "Description: \n" + "Earthy, Floral, Fruity");
        registry.addDescription(new ItemStack(CropRegistry.getFood("perlegermany")), "Hop Type: " + "Aroma", "Alpha Acid: " + "6.5", "Description: \n" + "Floral, Spicy, Fruity, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("perleusa")), "Hop Type: " + "Dual", "Alpha Acid: " + "7.5", "Description: \n" + "Floral, Spicy");
        registry.addDescription(new ItemStack(CropRegistry.getFood("phoenix")), "Hop Type: " + "Dual", "Alpha Acid: " + "10", "Description: \n" + "Floral, Stone");
        registry.addDescription(new ItemStack(CropRegistry.getFood("pilgrim")), "Hop Type: " + "Dual", "Alpha Acid: " + "11", "Description: \n" + "Fruity");
        registry.addDescription(new ItemStack(CropRegistry.getFood("pioneer")), "Hop Type: " + "Dual", "Alpha Acid: " + "10", "Description: \n" + "Citrus, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("polaris")), "Hop Type: " + "Dual", "Alpha Acid: " + "20.5", "Description: \n" + "Tropical Fruit, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("premiant")), "Hop Type: " + "Dual", "Alpha Acid: " + "8.5", "Description: \n" + "Mild");
        registry.addDescription(new ItemStack(CropRegistry.getFood("prideofringwood")), "Hop Type: " + "Bittering", "Alpha Acid: " + "9.5", "Description: \n" + "Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("progress")), "Hop Type: " + "Dual", "Alpha Acid: " + "6.25", "Description: \n" + "Earthy, Grassy, Fruity, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("rakau")), "Hop Type: " + "Dual", "Alpha Acid: " + "10.5", "Description: \n" + "Stone Fruit, Fruity, Pine");
        registry.addDescription(new ItemStack(CropRegistry.getFood("record")), "Hop Type: " + "Aroma", "Alpha Acid: " + "6.5", "Description: \n" + "Tropical Fruit");
        registry.addDescription(new ItemStack(CropRegistry.getFood("riwaka")), "Hop Type: " + "Aroma", "Alpha Acid: " + "5.5", "Description: \n" + "Citrus, Tropical Fruit");
        registry.addDescription(new ItemStack(CropRegistry.getFood("saaz")), "Hop Type: " + "Aroma", "Alpha Acid: " + "3.5", "Description: \n" + "Floral, Citrus, Spicy, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("santiam")), "Hop Type: " + "Aroma", "Alpha Acid: " + "7", "Description: \n" + "Floral, Spicy");
        registry.addDescription(new ItemStack(CropRegistry.getFood("saphir")), "Hop Type: " + "Aroma", "Alpha Acid: " + "3", "Description: \n" + "Flora, Citrus, Spicy, Fruity");
        registry.addDescription(new ItemStack(CropRegistry.getFood("satus")), "Hop Type: " + "Dual", "Alpha Acid: " + "13", "Description: \n" + "Tropical Fruit, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("savinjskigolding")), "Hop Type: " + "Aroma", "Alpha Acid: " + "5", "Description: \n" + "Earthy, Floral, Spicy");
        registry.addDescription(new ItemStack(CropRegistry.getFood("select")), "Hop Type: " + "Aroma", "Alpha Acid: " + "4", "Description: \n" + "Grassy, Spicy");
        registry.addDescription(new ItemStack(CropRegistry.getFood("simcoe")), "Hop Type: " + "Dual", "Alpha Acid: " + "13", "Description: \n" + "Earthy, Citrus, Pine");
        registry.addDescription(new ItemStack(CropRegistry.getFood("smaragd")), "Hop Type: " + "Dual", "Alpha Acid: " + "5", "Description: \n" + "Floral, Spicy");
        registry.addDescription(new ItemStack(CropRegistry.getFood("sorachiace")), "Hop Type: " + "Dual", "Alpha Acid: " + "13", "Description: \n" + "Citrus, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("southerncross")), "Hop Type: " + "Dual", "Alpha Acid: " + "12.5", "Description: \n" + "Citrus, Spicy, Tropical Fruit, Pine");
        registry.addDescription(new ItemStack(CropRegistry.getFood("sovereign")), "Hop Type: " + "Dual", "Alpha Acid: " + "5.5", "Description: \n" + "Fruity");
        registry.addDescription(new ItemStack(CropRegistry.getFood("spalt")), "Hop Type: " + "Aroma", "Alpha Acid: " + "4", "Description: \n" + "Earthy, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("sterling")), "Hop Type: " + "Aroma", "Alpha Acid: " + "7", "Description: \n" + "Floral, Citrus, Spicy, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("sticklebract")), "Hop Type: " + "Aroma", "Alpha Acid: " + "11.5", "Description: \n" + "Citrus, Spicy");
        registry.addDescription(new ItemStack(CropRegistry.getFood("strisselspalt")), "Hop Type: " + "Aroma", "Alpha Acid: " + "2", "Description: \n" + "Earthy, Grassy, Citrus, Spicy, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("styriangolding")), "Hop Type: " + "Dual", "Alpha Acid: " + "5.5", "Description: \n" + "Spicy, Fruity");
        registry.addDescription(new ItemStack(CropRegistry.getFood("summer")), "Hop Type: " + "Aroma", "Alpha Acid: " + "6", "Description: \n" + "Stone Fruit, Tropical Fruit, Fruity");
        registry.addDescription(new ItemStack(CropRegistry.getFood("summit")), "Hop Type: " + "Bittering", "Alpha Acid: " + "16", "Description: \n" + "Citrus, Spicy, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("superalpha")), "Hop Type: " + "Dual", "Alpha Acid: " + "13", "Description: \n" + "Tropical Fruit, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("superpride")), "Hop Type: " + "Bittering", "Alpha Acid: " + "14", "Description: \n" + "Pine");
        registry.addDescription(new ItemStack(CropRegistry.getFood("sussex")), "Hop Type: " + "Aroma", "Alpha Acid: " + "5", "Description: \n" + "Earthy, Grassy, Citrus, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("sylva")), "Hop Type: " + "Aroma", "Alpha Acid: " + "6.5", "Description: \n" + "Earthy, Floral, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("tahoma")), "Hop Type: " + "Aroma", "Alpha Acid: " + "7", "Description: \n" + "Floral, Citrus, Pine, Cedar");
        registry.addDescription(new ItemStack(CropRegistry.getFood("talisman")), "Hop Type: " + "Aroma", "Alpha Acid: " + "8", "Description: \n" + "Earthy, Floral, Fruity");
        registry.addDescription(new ItemStack(CropRegistry.getFood("target")), "Hop Type: " + "Dual", "Alpha Acid: " + "11.5", "Description: \n" + "Citrus, Spicy");
        registry.addDescription(new ItemStack(CropRegistry.getFood("tettnangergermany")), "Hop Type: " + "Aroma", "Alpha Acid: " + "4.5", "Description: \n" + "Spicy, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("tettnangerusa")), "Hop Type: " + "Aroma", "Alpha Acid: " + "5", "Description: \n" + "Earthy, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("tomahawk")), "Hop Type: " + "Bittering", "Alpha Acid: " + "16", "Description: \n" + "Citrus, Spicy, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("tradition")), "Hop Type: " + "Aroma", "Alpha Acid: " + "5.5", "Description: \n" + "Floral, Fruity, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("triplepearl")), "Hop Type: " + "Aroma", "Alpha Acid: " + "10", "Description: \n" + "Citrus, Spicy, Tropical Fruit, Pine");
        registry.addDescription(new ItemStack(CropRegistry.getFood("triskel")), "Hop Type: " + "Aroma", "Alpha Acid: " + "8.5", "Description: \n" + "Floral, Citrus, Spicy");
        registry.addDescription(new ItemStack(CropRegistry.getFood("ultra")), "Hop Type: " + "Aroma", "Alpha Acid: " + "9.5", "Description: \n" + "Floral, Spicy");
        registry.addDescription(new ItemStack(CropRegistry.getFood("vanguard")), "Hop Type: " + "Aroma", "Alpha Acid: " + "5.5", "Description: \n" + "Cedar");
        registry.addDescription(new ItemStack(CropRegistry.getFood("waiiti")), "Hop Type: " + "Aroma", "Alpha Acid: " + "3", "Description: \n" + "Citrus, Stone Fruit, Spicy, Fruity");
        registry.addDescription(new ItemStack(CropRegistry.getFood("waimea")), "Hop Type: " + "Dual", "Alpha Acid: " + "17.5", "Description: \n" + "Citrus, Pine");
        registry.addDescription(new ItemStack(CropRegistry.getFood("wakatu")), "Hop Type: " + "Dual", "Alpha Acid: " + "7.5", "Description: \n" + "Floral, Citrus");
        registry.addDescription(new ItemStack(CropRegistry.getFood("warrior")), "Hop Type: " + "Bittering", "Alpha Acid: " + "16.5", "Description: \n" + "Pine, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("whitbreadgolding")), "Hop Type: " + "Aroma", "Alpha Acid: " + "6.5", "Description: \n" + "Earthy, Floral, Fruity");
        registry.addDescription(new ItemStack(CropRegistry.getFood("willamette")), "Hop Type: " + "Aroma", "Alpha Acid: " + "5.5", "Description: \n" + "Floral, Fruity, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("yakimacluster")), "Hop Type: " + "Aroma", "Alpha Acid: " + "7", "Description: \n" + "Fruity");
        registry.addDescription(new ItemStack(CropRegistry.getFood("yamhillgolding")), "Hop Type: " + "Aroma", "Alpha Acid: " + "4", "Description: \n" + "Earthy");
        registry.addDescription(new ItemStack(CropRegistry.getFood("yeoman")), "Hop Type: " + "Aroma", "Alpha Acid: " + "7.25", "Description: \n" + "Earthy, Floral, Fruity");
        registry.addDescription(new ItemStack(CropRegistry.getFood("zenith")), "Hop Type: " + "Bittering", "Alpha Acid: " + "9", "Description: \n" + "Floral, Spicy");
        registry.addDescription(new ItemStack(CropRegistry.getFood("zeus")), "Hop Type: " + "Bittering", "Alpha Acid: " + "16", "Description: \n" + "Spicy, Herbal");
        registry.addDescription(new ItemStack(CropRegistry.getFood("zythos")), "Hop Type: " + "Aroma", "Alpha Acid: " + "17", "Description: \n" + "Citrus, Tropical Fruit");


    }
}
