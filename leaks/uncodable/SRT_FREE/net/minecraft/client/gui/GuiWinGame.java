package net.minecraft.client.gui;

import com.google.common.collect.Lists;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;
import net.minecraft.client.audio.MusicTicker;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.network.play.client.C16PacketClientStatus;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.Charsets;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GuiWinGame extends GuiScreen {
   private static final Logger logger = LogManager.getLogger();
   private static final ResourceLocation MINECRAFT_LOGO = new ResourceLocation("textures/gui/title/minecraft.png");
   private static final ResourceLocation VIGNETTE_TEXTURE = new ResourceLocation("textures/misc/vignette.png");
   private int field_146581_h;
   private List<String> field_146582_i;
   private int field_146579_r;
   private final float field_146578_s = 0.5F;

   @Override
   public void updateScreen() {
      MusicTicker musicticker = this.mc.func_181535_r();
      SoundHandler soundhandler = this.mc.getSoundHandler();
      if (this.field_146581_h == 0) {
         musicticker.func_181557_a();
         musicticker.func_181558_a(MusicTicker.MusicType.CREDITS);
         soundhandler.resumeSounds();
      }

      soundhandler.update();
      ++this.field_146581_h;
      float f = (float)(this.field_146579_r + this.height + this.height + 24) / 0.5F;
      if ((float)this.field_146581_h > f) {
         this.sendRespawnPacket();
      }
   }

   @Override
   protected void keyTyped(char typedChar, int keyCode) {
      if (keyCode == 1) {
         this.sendRespawnPacket();
      }
   }

   private void sendRespawnPacket() {
      this.mc.thePlayer.sendQueue.addToSendQueue(new C16PacketClientStatus(C16PacketClientStatus.EnumState.PERFORM_RESPAWN));
      this.mc.displayGuiScreen(null);
   }

   @Override
   public boolean doesGuiPauseGame() {
      return true;
   }

   @Override
   public void initGui() {
      if (this.field_146582_i == null) {
         this.field_146582_i = Lists.newArrayList();

         try {
            String s1 = "" + EnumChatFormatting.WHITE + EnumChatFormatting.OBFUSCATED + EnumChatFormatting.GREEN + EnumChatFormatting.AQUA;
            int i = 274;
            InputStream inputstream = this.mc.getResourceManager().getResource(new ResourceLocation("texts/end.txt")).getInputStream();
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(inputstream, Charsets.UTF_8));
            Random random = new Random(8124371L);

            String s;
            while((s = bufferedreader.readLine()) != null) {
               String s2;
               String s3;
               for(s = s.replaceAll("PLAYERNAME", this.mc.getSession().getUsername());
                  s.contains(s1);
                  s = s2 + EnumChatFormatting.WHITE + EnumChatFormatting.OBFUSCATED + "XXXXXXXX".substring(0, random.nextInt(4) + 3) + s3
               ) {
                  int j = s.indexOf(s1);
                  s2 = s.substring(0, j);
                  s3 = s.substring(j + s1.length());
               }

               this.field_146582_i.addAll(this.mc.fontRendererObj.listFormattedStringToWidth(s, i));
               this.field_146582_i.add("");
            }

            inputstream.close();

            for(int k = 0; k < 8; ++k) {
               this.field_146582_i.add("");
            }

            inputstream = this.mc.getResourceManager().getResource(new ResourceLocation("texts/credits.txt")).getInputStream();
            bufferedreader = new BufferedReader(new InputStreamReader(inputstream, Charsets.UTF_8));

            while((s = bufferedreader.readLine()) != null) {
               s = s.replaceAll("PLAYERNAME", this.mc.getSession().getUsername());
               s = s.replaceAll("\t", "    ");
               this.field_146582_i.addAll(this.mc.fontRendererObj.listFormattedStringToWidth(s, i));
               this.field_146582_i.add("");
            }

            inputstream.close();
            this.field_146579_r = this.field_146582_i.size() * 12;
         } catch (Exception var10) {
            logger.error("Couldn't load credits", var10);
         }
      }
   }

   private void drawWinGameScreen(int p_146575_1_, int p_146575_2_, float p_146575_3_) {
      Tessellator tessellator = Tessellator.getInstance();
      WorldRenderer worldrenderer = tessellator.getWorldRenderer();
      this.mc.getTextureManager().bindTexture(Gui.optionsBackground);
      worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181709_i);
      int i = this.width;
      float f = 0.0F - ((float)this.field_146581_h + p_146575_3_) * 0.5F * 0.5F;
      float f1 = (float)this.height - ((float)this.field_146581_h + p_146575_3_) * 0.5F * 0.5F;
      float f2 = 0.015625F;
      float f3 = ((float)this.field_146581_h + p_146575_3_ - 0.0F) * 0.02F;
      float f4 = (float)(this.field_146579_r + this.height + this.height + 24) / 0.5F;
      float f5 = (f4 - 20.0F - ((float)this.field_146581_h + p_146575_3_)) * 0.005F;
      if (f5 < f3) {
         f3 = f5;
      }

      if (f3 > 1.0F) {
         f3 = 1.0F;
      }

      f3 *= f3;
      f3 = f3 * 96.0F / 255.0F;
      worldrenderer.func_181662_b(0.0, (double)this.height, (double)this.zLevel)
         .func_181673_a(0.0, (double)(f * f2))
         .func_181666_a(f3, f3, f3, 1.0F)
         .func_181675_d();
      worldrenderer.func_181662_b((double)i, (double)this.height, (double)this.zLevel)
         .func_181673_a((double)((float)i * f2), (double)(f * f2))
         .func_181666_a(f3, f3, f3, 1.0F)
         .func_181675_d();
      worldrenderer.func_181662_b((double)i, 0.0, (double)this.zLevel)
         .func_181673_a((double)((float)i * f2), (double)(f1 * f2))
         .func_181666_a(f3, f3, f3, 1.0F)
         .func_181675_d();
      worldrenderer.func_181662_b(0.0, 0.0, (double)this.zLevel).func_181673_a(0.0, (double)(f1 * f2)).func_181666_a(f3, f3, f3, 1.0F).func_181675_d();
      tessellator.draw();
   }

   @Override
   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
      this.drawWinGameScreen(mouseX, mouseY, partialTicks);
      Tessellator tessellator = Tessellator.getInstance();
      WorldRenderer worldrenderer = tessellator.getWorldRenderer();
      int i = 274;
      int j = this.width / 2 - i / 2;
      int k = this.height + 50;
      float f = -((float)this.field_146581_h + partialTicks) * 0.5F;
      GlStateManager.pushMatrix();
      GlStateManager.translate(0.0F, f, 0.0F);
      this.mc.getTextureManager().bindTexture(MINECRAFT_LOGO);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      this.drawTexturedModalRect(j, k, 0, 0, 155, 44);
      this.drawTexturedModalRect(j + 155, k, 0, 45, 155, 44);
      int l = k + 200;

      for(int i1 = 0; i1 < this.field_146582_i.size(); ++i1) {
         if (i1 == this.field_146582_i.size() - 1) {
            float f1 = (float)l + f - (float)(this.height / 2 - 6);
            if (f1 < 0.0F) {
               GlStateManager.translate(0.0F, -f1, 0.0F);
            }
         }

         if ((float)l + f + 12.0F + 8.0F > 0.0F && (float)l + f < (float)this.height) {
            String s = this.field_146582_i.get(i1);
            if (s.startsWith("[C]")) {
               this.fontRendererObj
                  .drawStringWithShadow(s.substring(3), (float)(j + (i - this.fontRendererObj.getStringWidth(s.substring(3))) / 2), (float)l, 16777215);
            } else {
               this.fontRendererObj.fontRandom.setSeed((long)i1 * 4238972211L + (long)(this.field_146581_h / 4));
               this.fontRendererObj.drawStringWithShadow(s, (float)j, (float)l, 16777215);
            }
         }

         l += 12;
      }

      GlStateManager.popMatrix();
      this.mc.getTextureManager().bindTexture(VIGNETTE_TEXTURE);
      GlStateManager.enableBlend();
      GlStateManager.blendFunc(0, 769);
      int j1 = this.width;
      int k1 = this.height;
      worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181709_i);
      worldrenderer.func_181662_b(0.0, (double)k1, (double)this.zLevel).func_181673_a(0.0, 1.0).func_181666_a(1.0F, 1.0F, 1.0F, 1.0F).func_181675_d();
      worldrenderer.func_181662_b((double)j1, (double)k1, (double)this.zLevel).func_181673_a(1.0, 1.0).func_181666_a(1.0F, 1.0F, 1.0F, 1.0F).func_181675_d();
      worldrenderer.func_181662_b((double)j1, 0.0, (double)this.zLevel).func_181673_a(1.0, 0.0).func_181666_a(1.0F, 1.0F, 1.0F, 1.0F).func_181675_d();
      worldrenderer.func_181662_b(0.0, 0.0, (double)this.zLevel).func_181673_a(0.0, 0.0).func_181666_a(1.0F, 1.0F, 1.0F, 1.0F).func_181675_d();
      tessellator.draw();
      GlStateManager.disableBlend();
      super.drawScreen(mouseX, mouseY, partialTicks);
   }
}