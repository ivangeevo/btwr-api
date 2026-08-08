package org.btwr.api.api.difficulty.impl;

import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.Map;

public final class BTWRDifficulty {
    private final DifficultyInfo info;
    private final Map<DifficultyParam<?>, Object> values;

    BTWRDifficulty(DifficultyInfo info, Map<DifficultyParam<?>, Object> values) {
        this.info = info;
        this.values = values;
    }

    public DifficultyInfo info() {
        return info;
    }
    public Map<DifficultyParam<?>, Object>  values() {
        return values;
    }

    @SuppressWarnings("unchecked")
    public <T> T get(DifficultyParam<T> parameter) {
        Object value = values.get(parameter);
        return value != null ? (T) value : parameter.defaultValue();
    }

    public Text getDisplayName() {
        return Text.translatable("difficulty.btwr." + info.id().getPath());
    }

    public Text getTooltip() {
        return Text.translatable("difficulty.btwr." + info.id().getPath() + ".tooltip");
    }

    public static class Builder {
        private final DifficultyInfo info;
        /** Holds the value of a difficulty parameter. Used to build difficulties. **/
        private final Map<DifficultyParam<?>, Object> PARAMETER_VALUES = new LinkedHashMap<>();
        /** Holds the value of a difficulty parameter's identifier. Used to specify what parameters a difficulty has. **/
        private static final Map<DifficultyParam<?>, Identifier> PARAMETER_IDS = new LinkedHashMap<>();

        public static Map<DifficultyParam<?>, Identifier> getParameterIds() {
            return PARAMETER_IDS;
        }

        public Builder(DifficultyInfo info) {
            this.info = info;
            PARAMETER_IDS.forEach(
                    (param,id) -> PARAMETER_VALUES.put(param, param.defaultValue())
            );
        }

        public BTWRDifficulty.Builder inherit(BTWRDifficulty difficulty) {
            PARAMETER_VALUES.clear();
            PARAMETER_VALUES.putAll(difficulty.values());
            return this;
        }

        public <T> BTWRDifficulty.Builder setParam(DifficultyParam<T> parameter, T value) {
            PARAMETER_VALUES.put(parameter, value);
            return this;
        }

        public BTWRDifficulty build() {
            return new BTWRDifficulty(info, PARAMETER_VALUES);
        }
    }




}