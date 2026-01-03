package utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 实现将实体类对象中的属性根据非空检查生成并返回为Object[]的工具类
 */
public class EntityToArrayConverter {

    /**
     * 将实体类中非空且非默认值的属性值添加到 Object[] 数组中
     *
     * @param entity 实体类对象
     * @return 包含所有非空且非默认值属性值的 Object[] 数组
     */
    public static Object[] getNonNullProperties(Object entity) {
        if (entity == null) {
            return new Object[0];
        }

        List<Object> values = new ArrayList<>();
        Class<?> clazz = entity.getClass();

        // 遍历所有声明的字段
        for (Field field : clazz.getDeclaredFields()) {
            try {
                // 设置可访问性以访问私有字段
                field.setAccessible(true);

                // 获取字段值
                Object value = field.get(entity);

                // 检查字段是否应该被包含
                if (shouldIncludeValue(field, value)) {
                    values.add(value);
                }
            } catch (IllegalAccessException e) {
                System.err.println("无法访问字段: " + field.getName());
            }
        }

        // 将 List 转换为 Object[]
        return values.toArray();
    }

    /**
     * 判断字段值是否应该被包含在结果数组中
     *
     * @param field 字段对象
     * @param value 字段值
     * @return 是否应该包含该值
     */
    private static boolean shouldIncludeValue(Field field, Object value) {
        // 如果值为 null，不包含
        if (value == null || value=="") {
            return false;
        }

        // 获取字段类型
        Class<?> type = field.getType();

        // 处理基本类型及其默认值
        if (type.isPrimitive()) {
            return !isPrimitiveDefaultValue(type, value);
        }

        // 处理包装类型
        return !isWrapperDefaultValue(type, value);
    }

    /**
     * 检查基本类型值是否为默认值
     *
     * @param type 字段类型
     * @param value 字段值
     * @return 是否为默认值
     */
    private static boolean isPrimitiveDefaultValue(Class<?> type, Object value) {
        if (int.class.equals(type) && (int) value == 0) {
            return true;
        }
        if (long.class.equals(type) && (long) value == 0L) {
            return true;
        }
        if (double.class.equals(type) && (double) value == 0.0) {
            return true;
        }
        if (float.class.equals(type) && (float) value == 0.0f) {
            return true;
        }
        if (short.class.equals(type) && (short) value == 0) {
            return true;
        }
        if (byte.class.equals(type) && (byte) value == 0) {
            return true;
        }
        if (char.class.equals(type) && (char) value == '\u0000') {
            return true;
        }
        if (boolean.class.equals(type) && !(boolean) value) {
            return true;
        }
        return false;
    }

    /**
     * 检查包装类型值是否为默认值
     *
     * @param type 字段类型
     * @param value 字段值
     * @return 是否为默认值
     */
    private static boolean isWrapperDefaultValue(Class<?> type, Object value) {
        if (Integer.class.equals(type) && (Integer) value == 0) {
            return true;
        }
        if (Long.class.equals(type) && (Long) value == 0L) {
            return true;
        }
        if (Double.class.equals(type) && (Double) value == 0.0) {
            return true;
        }
        if (Float.class.equals(type) && (Float) value == 0.0f) {
            return true;
        }
        if (Short.class.equals(type) && (Short) value == 0) {
            return true;
        }
        if (Byte.class.equals(type) && (Byte) value == 0) {
            return true;
        }
        if (Character.class.equals(type) && (Character) value == '\u0000') {
            return true;
        }
        if (Boolean.class.equals(type) && !(Boolean) value) {
            return true;
        }
        return false;
    }

    /**
     * 将实体类中非空且非默认值的属性值添加到 Object[] 数组中
     * 支持对指定属性进行模糊查询格式化（添加 %值%）
     *
     * @param entity 实体类对象
     * @param likeFields 需要进行模糊查询的字段名集合
     * @return 包含所有处理后的属性值的 Object[] 数组
     */
    public static Object[] getNonNullProperties(Object entity, Set<String> likeFields) {
        if (entity == null) {
            return new Object[0];
        }

        List<Object> values = new ArrayList<>();
        Class<?> clazz = entity.getClass();

        // 遍历所有声明的字段
        for (Field field : clazz.getDeclaredFields()) {
            try {
                // 设置可访问性以访问私有字段
                field.setAccessible(true);

                // 获取字段值
                Object value = field.get(entity);

                // 检查字段是否应该被包含
                if (shouldIncludeValue(field, value)) {
                    // 对指定字段进行模糊查询格式化
                    if (likeFields != null && likeFields.contains(field.getName())) {
                        value = formatLikeValue(value);
                    }
                    values.add(value);
                }
            } catch (IllegalAccessException e) {
                System.err.println("无法访问字段: " + field.getName());
            }
        }

        // 将 List 转换为 Object[]
        return values.toArray();
    }

    /**
     * 将值格式化为模糊查询格式
     *
     * @param value 原始值
     * @return 格式化后的值，如 "%关键字%"
     */
    private static Object formatLikeValue(Object value) {
        if (value == null) {
            return null;
        }

        // 只对字符串类型进行模糊查询格式化
        if (value instanceof String) {
            String strValue = (String) value;
            if (!strValue.trim().isEmpty()) {
                return "%" + strValue + "%";
            }
        }

        // 对于非字符串类型，保持原值
        return value;
    }

    /**
     * 将实体类中非空且非默认值的属性值添加到 Object[] 数组中
     * 支持对指定属性进行模糊查询格式化（添加 %值%）
     *
     * @param entity 实体类对象
     * @param likeFields 需要进行模糊查询的字段名集合
     * @return 包含所有处理后的属性值的 Object[] 数组
     */
    public static Object[] getNonNullProperties(Object entity, Set<String> likeFields, Set<String> doubleFields) {
        if (entity == null) {
            return new Object[0];
        }

        List<Object> values = new ArrayList<>();
        Class<?> clazz = entity.getClass();

        // 遍历所有声明的字段
        for (Field field : clazz.getDeclaredFields()) {
            try {
                // 设置可访问性以访问私有字段
                field.setAccessible(true);

                // 获取字段值
                Object value = field.get(entity);

                // 检查字段是否应该被包含
                if (shouldIncludeValue(field, value)) {
                    // 对指定字段进行模糊查询格式化
                    if (likeFields != null && likeFields.contains(field.getName())) {
                        value = formatLikeValue(value);
                    }

                    // 对指定字段判断是否需要双写
                    if(doubleFields != null && doubleFields.contains(field.getName())){
                        values.add(value);
                        values.add(value);
                    }else{
                        values.add(value);
                    }

                }
            } catch (IllegalAccessException e) {
                System.err.println("无法访问字段: " + field.getName());
            }
        }

        // 将 List 转换为 Object[]
        return values.toArray();
    }

}