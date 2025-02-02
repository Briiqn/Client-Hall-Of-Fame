package me.r.touchgrass.ui.clickgui.component;

import java.awt.*;
import java.util.ArrayList;

import me.r.touchgrass.module.Category;
import me.r.touchgrass.module.Module;
import me.r.touchgrass.ui.clickgui.component.components.Button;
import me.r.touchgrass.font.FontUtil;
import me.r.touchgrass.utils.RenderUtil;
import me.r.touchgrass.touchgrass;
import me.r.touchgrass.module.modules.gui.ClickGUI;
import net.minecraft.client.gui.FontRenderer;

public class Frame {

	public final ArrayList<me.r.touchgrass.ui.clickgui.component.Component> components;
	public final Category category;
	public boolean open;
	public final int width;
	public int y;
	public int x;
	public final int barHeight;
	private boolean isDragging;
	public int dragX;
	public int dragY;

	public Frame(Category cat) {
		this.components = new ArrayList<>();
		this.category = cat;
		this.width = 88;
		this.x = 5;
		this.y = 5;
		this.barHeight = 13;
		this.dragX = 0;
		this.open = false;
		this.isDragging = false;
		int tY = this.barHeight;


		for (Module mod : touchgrass.getClient().moduleManager.getModulesInCategory(category)) {
			Button modButton = new Button(mod, this, tY);
			this.components.add(modButton);
			tY += 12;
		}
	}

	public ArrayList<me.r.touchgrass.ui.clickgui.component.Component> getComponents() {
		return components;
	}

	public void setX(int newX) {
		this.x = newX;
	}

	public void setY(int newY) {
		this.y = newY;
	}

	public void setDrag(boolean drag) {
		this.isDragging = drag;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public void renderFrame(FontRenderer fontRenderer) {
		Module cgui = touchgrass.getClient().moduleManager.getModule(ClickGUI.class);
		int color = new Color((int)touchgrass.getClient().settingsManager.getSettingByName(cgui, "Red").getValue(), (int)touchgrass.getClient().settingsManager.getSettingByName(cgui, "Green").getValue(), (int)touchgrass.getClient().settingsManager.getSettingByName(cgui, "Blue").getValue(), (int)touchgrass.getClient().settingsManager.getSettingByName(cgui, "Alpha").getValue()).getRGB();
		RenderUtil.rect(this.x - 2, this.y - 2, this.x + this.width + 2, this.y + this.barHeight, color);

		if(touchgrass.getClient().settingsManager.getSettingByName("Font Type").getMode().equalsIgnoreCase("TTF")) {
			FontUtil.drawTotalCenteredStringWithShadowVerdana(this.category.name(), (this.x + this.width / 2), (this.y + 7) - 3, Color.white);
		} else {
			FontUtil.drawTotalCenteredStringWithShadowMC(this.category.name(), (this.x + this.width / 2), (this.y + 7) - 1, -1);
		}

		for (me.r.touchgrass.ui.clickgui.component.Component component : this.components) {
			if (this.open) {
				if (!this.components.isEmpty()) {
					component.renderComponent();
				}
			}
		}
	}

	public void refresh() {
		int off = this.barHeight;
		for (Component comp : components) {
			comp.setOff(off);
			off += comp.getHeight();
		}
	}


	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public void updatePosition(int mouseX, int mouseY) {
		if (this.isDragging) {
			this.setX(mouseX - dragX);
			this.setY(mouseY - dragY);
		}
	}

	public boolean isWithinHeader(int x, int y) {
		return x >= this.x && x <= this.x + this.width && y >= this.y && y <= this.y + this.barHeight;
	}
}
