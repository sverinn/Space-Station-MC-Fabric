package com.sverinn.ssmc.object.tool;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;

import java.util.List;

public class BaseToolItem extends Item {
    public BaseToolItem(Settings settings) {
        super(settings);
    }
/*
 private final ToolPrototype prototype;

            public BaseToolItem(ToolPrototype prototype) {
            super(new Settings().maxCount(1));
            this.prototype = prototype;
        }

            public static void registerTools(List<ToolPrototype> prototypes) {
            for (ToolPrototype proto : prototypes) {
                    BaseToolItem tool = createToolFromPrototype(proto);
                    Registry.register(Registries.ITEM, new Identifier("ssmc", proto.getId()), tool);
                }
        }

            private static BaseToolItem createToolFromPrototype(ToolPrototype proto) {

            if (proto.getId().equals("Multitool") || proto.getId().equals("Omnitool")) {
                    return new MultiFunctionToolItem(proto);
                } else if (proto.getId().equals("RCD")) {
                    return new RCDItem(proto);
                }
            return new BaseToolItem(proto);
        }
        */
}