package hantianyu1504d.bwie.com.avenue.core.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by lichaohui on 2017/7/14.
 * 功能  缓存
 * 描述： 以key  values  形式进行缓存
 */

public class ACache {
    public static final int TIME_HOUR = 60 * 60;
    public static final int TIME_DAY = TIME_HOUR * 24;
    private static final int MAX_SIZE = 1000 * 1000 * 50; // 50 mb
    private static final int MAX_COUNT = Integer.MAX_VALUE; // ä¸é™åˆ¶å­˜æ”¾æ•°æ®çš„æ•°é‡
    private static Map<String, ACache> mInstanceMap = new HashMap<String, ACache>();
    private ACacheManager mCache;

    public static ACache get(Context ctx) {
        return get(ctx, "ACache");
    }

    public static ACache get(Context ctx, String cacheName) {  //æ›´æ”¹ä¸ºéžç¼“å­˜
        File f = new File(ctx.getFilesDir(), cacheName);
        return get(f, MAX_SIZE, MAX_COUNT);
    }

    public static ACache get(File cacheDir) {
        return get(cacheDir, MAX_SIZE, MAX_COUNT);
    }

    public static ACache get(Context ctx, long max_zise, int max_count) {
        File f = new File(ctx.getFilesDir(), "ACache");
        return get(f, max_zise, max_count);
    }

    public static ACache get(File cacheDir, long max_zise, int max_count) {
        ACache manager = mInstanceMap.get(cacheDir.getAbsoluteFile() + myPid());
        if (manager == null) {
            manager = new ACache(cacheDir, max_zise, max_count);
            mInstanceMap.put(cacheDir.getAbsolutePath() + myPid(), manager);
        }
        return manager;
    }

    private static String myPid() {
        return "_" + android.os.Process.myPid();
    }

    private ACache(File cacheDir, long max_size, int max_count) {
        if (!cacheDir.exists() && !cacheDir.mkdirs()) {
            throw new RuntimeException("can't make dirs in "
                    + cacheDir.getAbsolutePath());
        }
        mCache = new ACacheManager(cacheDir, max_size, max_count);
    }

    // =======================================
    // ============ Stringæ•°æ® è¯»å†™ ==============
    // =======================================
    /**
     * ä¿å­˜ Stringæ•°æ® åˆ?ç¼“å­˜ä¸?
     *
     * @param key
     *            ä¿å­˜çš„key
     * @param value
     *            ä¿å­˜çš„Stringæ•°æ®
     */
    public void put(String key, String value) {
        File file = mCache.newFile(key);
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter(file), 1024);
            out.write(value);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            mCache.put(file);
        }
    }

    /**
     * ä¿å­˜ Stringæ•°æ® åˆ?ç¼“å­˜ä¸?
     *
     * @param key
     *            ä¿å­˜çš„key
     * @param value
     *            ä¿å­˜çš„Stringæ•°æ®
     * @param saveTime
     *            ä¿å­˜çš„æ—¶é—´ï¼Œå•ä½ï¼šç§’
     */
    public void put(String key, String value, int saveTime) {
        put(key, Utils.newStringWithDateInfo(saveTime, value));
    }

    /**
     * è¯»å– Stringæ•°æ®
     *
     * @param key
     * @return String æ•°æ®
     */
    public String getAsString(String key) {
        File file = mCache.get(key);
        if (!file.exists())
            return null;
        boolean removeFile = false;
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(file));
            String readString = "";
            String currentLine;
            while ((currentLine = in.readLine()) != null) {
                readString += currentLine;
            }
            if (!Utils.isDue(readString)) {
                return Utils.clearDateInfo(readString);
            } else {
                removeFile = true;
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (removeFile)
                remove(key);
        }
    }

    // =======================================
    // ============= JSONObject æ•°æ® è¯»å†™ ==============
    // =======================================
    /**
     * ä¿å­˜ JSONObjectæ•°æ® åˆ?ç¼“å­˜ä¸?
     *
     * @param key
     *            ä¿å­˜çš„key
     * @param value
     *            ä¿å­˜çš„JSONæ•°æ®
     */
    public void put(String key, JSONObject value) {
        put(key, value.toString());
    }

    /**
     * ä¿å­˜ JSONObjectæ•°æ® åˆ?ç¼“å­˜ä¸?
     *
     * @param key
     *            ä¿å­˜çš„key
     * @param value
     *            ä¿å­˜çš„JSONObjectæ•°æ®
     * @param saveTime
     *            ä¿å­˜çš„æ—¶é—´ï¼Œå•ä½ï¼šç§’
     */
    public void put(String key, JSONObject value, int saveTime) {
        put(key, value.toString(), saveTime);
    }

    /**
     * è¯»å–JSONObjectæ•°æ®
     *
     * @param key
     * @return JSONObjectæ•°æ®
     */
    public JSONObject getAsJSONObject(String key) {
        String JSONString = getAsString(key);
        try {
            JSONObject obj = new JSONObject(JSONString);
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // =======================================
    // ============ JSONArray æ•°æ® è¯»å†™ =============
    // =======================================
    /**
     * ä¿å­˜ JSONArrayæ•°æ® åˆ?ç¼“å­˜ä¸?
     *
     * @param key
     *            ä¿å­˜çš„key
     * @param value
     *            ä¿å­˜çš„JSONArrayæ•°æ®
     */
    public void put(String key, JSONArray value) {
        put(key, value.toString());
    }

    /**
     * ä¿å­˜ JSONArrayæ•°æ® åˆ?ç¼“å­˜ä¸?
     *
     * @param key
     *            ä¿å­˜çš„key
     * @param value
     *            ä¿å­˜çš„JSONArrayæ•°æ®
     * @param saveTime
     *            ä¿å­˜çš„æ—¶é—´ï¼Œå•ä½ï¼šç§’
     */
    public void put(String key, JSONArray value, int saveTime) {
        put(key, value.toString(), saveTime);
    }

    /**
     * è¯»å–JSONArrayæ•°æ®
     *
     * @param key
     * @return JSONArrayæ•°æ®
     */
    public JSONArray getAsJSONArray(String key) {
        String JSONString = getAsString(key);
        try {
            JSONArray obj = new JSONArray(JSONString);
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // =======================================
    // ============== byte æ•°æ® è¯»å†™ =============
    // =======================================
    /**
     * ä¿å­˜ byteæ•°æ® åˆ?ç¼“å­˜ä¸?
     *
     * @param key
     *            ä¿å­˜çš„key
     * @param value
     *            ä¿å­˜çš„æ•°æ?
     */
    public void put(String key, byte[] value) {
        File file = mCache.newFile(key);
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(file);
            out.write(value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            mCache.put(file);
        }
    }

    /**
     * ä¿å­˜ byteæ•°æ® åˆ?ç¼“å­˜ä¸?
     *
     * @param key
     *            ä¿å­˜çš„key
     * @param value
     *            ä¿å­˜çš„æ•°æ?
     * @param saveTime
     *            ä¿å­˜çš„æ—¶é—´ï¼Œå•ä½ï¼šç§’
     */
    public void put(String key, byte[] value, int saveTime) {
        put(key, Utils.newByteArrayWithDateInfo(saveTime, value));
    }

    /**
     * èŽ·å– byte æ•°æ®
     *
     * @param key
     * @return byte æ•°æ®
     */
    public byte[] getAsBinary(String key) {
        RandomAccessFile RAFile = null;
        boolean removeFile = false;
        try {
            File file = mCache.get(key);
            if (!file.exists())
                return null;
            RAFile = new RandomAccessFile(file, "r");
            byte[] byteArray = new byte[(int) RAFile.length()];
            RAFile.read(byteArray);
            if (!Utils.isDue(byteArray)) {
                return Utils.clearDateInfo(byteArray);
            } else {
                removeFile = true;
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (RAFile != null) {
                try {
                    RAFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (removeFile)
                remove(key);
        }
    }

    // =======================================
    // ============= åºåˆ—åŒ?æ•°æ® è¯»å†™ ===============
    // =======================================
    /**
     * ä¿å­˜ Serializableæ•°æ® åˆ?ç¼“å­˜ä¸?
     *
     * @param key
     *            ä¿å­˜çš„key
     * @param value
     *            ä¿å­˜çš„value
     */
    public void put(String key, Serializable value) {
        put(key, value, -1);
    }



    /**
     * ä¿å­˜ Serializableæ•°æ®åˆ?ç¼“å­˜ä¸?
     *
     * @param key
     *            ä¿å­˜çš„key
     * @param value
     *            ä¿å­˜çš„value
     * @param saveTime
     *            ä¿å­˜çš„æ—¶é—´ï¼Œå•ä½ï¼šç§’
     */
    public void put(String key, Serializable value, int saveTime) {
        ByteArrayOutputStream baos = null;
        ObjectOutputStream oos = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(value);
            byte[] data = baos.toByteArray();
            if (saveTime != -1) {
                put(key, data, saveTime);
            } else {
                put(key, data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
            }
        }
    }

    /**
     * è¯»å– Serializableæ•°æ®
     *
     * @param key
     * @return Serializable æ•°æ®
     */
    public Object getAsObject(String key) {
        byte[] data = getAsBinary(key);
        if (data != null) {
            ByteArrayInputStream bais = null;
            ObjectInputStream ois = null;
            try {
                bais = new ByteArrayInputStream(data);
                ois = new ObjectInputStream(bais);
                Object reObject = ois.readObject();
                return reObject;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            } finally {
                try {
                    if (bais != null)
                        bais.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if (ois != null)
                        ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;

    }

    public Boolean getAsBoolean(String key, Boolean defaultBoolean) {
        byte[] data = getAsBinary(key);
        if (data != null) {
            ByteArrayInputStream bais = null;
            ObjectInputStream ois = null;
            try {
                bais = new ByteArrayInputStream(data);
                ois = new ObjectInputStream(bais);
                Object reObject = ois.readObject();
                return (Boolean) reObject;
            } catch (Exception e) {
                e.printStackTrace();
                return defaultBoolean;
            } finally {
                try {
                    if (bais != null)
                        bais.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if (ois != null)
                        ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return defaultBoolean;

    }

    // =======================================
    // ============== bitmap æ•°æ® è¯»å†™ =============
    // =======================================
    /**
     * ä¿å­˜ bitmap åˆ?ç¼“å­˜ä¸?
     *
     * @param key
     *            ä¿å­˜çš„key
     * @param value
     *            ä¿å­˜çš„bitmapæ•°æ®
     */
    public void put(String key, Bitmap value) {
        put(key, Utils.Bitmap2Bytes(value));
    }

    /**
     * ä¿å­˜ bitmap åˆ?ç¼“å­˜ä¸?
     *
     * @param key
     *            ä¿å­˜çš„key
     * @param value
     *            ä¿å­˜çš?bitmap æ•°æ®
     * @param saveTime
     *            ä¿å­˜çš„æ—¶é—´ï¼Œå•ä½ï¼šç§’
     */
    public void put(String key, Bitmap value, int saveTime) {
        put(key, Utils.Bitmap2Bytes(value), saveTime);
    }

    /**
     * è¯»å– bitmap æ•°æ®
     *
     * @param key
     * @return bitmap æ•°æ®
     */
    public Bitmap getAsBitmap(String key) {
        if (getAsBinary(key) == null) {
            return null;
        }
        return Utils.Bytes2Bimap(getAsBinary(key));
    }

    // =======================================
    // ============= drawable æ•°æ® è¯»å†™ =============
    // =======================================
    /**
     * ä¿å­˜ drawable åˆ?ç¼“å­˜ä¸?
     *
     * @param key
     *            ä¿å­˜çš„key
     * @param value
     *            ä¿å­˜çš„drawableæ•°æ®
     */
    public void put(String key, Drawable value) {
        put(key, Utils.drawable2Bitmap(value));
    }

    /**
     * ä¿å­˜ drawable åˆ?ç¼“å­˜ä¸?
     *
     * @param key
     *            ä¿å­˜çš„key
     * @param value
     *            ä¿å­˜çš?drawable æ•°æ®
     * @param saveTime
     *            ä¿å­˜çš„æ—¶é—´ï¼Œå•ä½ï¼šç§’
     */
    public void put(String key, Drawable value, int saveTime) {
        put(key, Utils.drawable2Bitmap(value), saveTime);
    }

    /**
     * è¯»å– Drawable æ•°æ®
     *
     * @param key
     * @return Drawable æ•°æ®
     */
    public Drawable getAsDrawable(String key) {
        if (getAsBinary(key) == null) {
            return null;
        }
        return Utils.bitmap2Drawable(Utils.Bytes2Bimap(getAsBinary(key)));
    }

    /**
     * èŽ·å–ç¼“å­˜æ–‡ä»¶
     *
     * @param key
     * @return value ç¼“å­˜çš„æ–‡ä»?
     */
    public File file(String key) {
        File f = mCache.newFile(key);
        if (f.exists())
            return f;
        return null;
    }

    /**
     * ç§»é™¤æŸä¸ªkey
     *
     * @param key
     * @return æ˜¯å¦ç§»é™¤æˆåŠŸ
     */
    public boolean remove(String key) {
        return mCache.remove(key);
    }

    /**
     * æ¸…é™¤æ‰?œ‰æ•°æ®
     */
    public void clear() {
        mCache.clear();
    }

    /**
     * @title ç¼“å­˜ç®¡ç†å™?
     * @author æ¨ç¦æµ·ï¼ˆmichaelï¼?www.yangfuhai.com
     * @version 1.0
     */
    public class ACacheManager {
        private final AtomicLong cacheSize;
        private final AtomicInteger cacheCount;
        private final long sizeLimit;
        private final int countLimit;
        private final Map<File, Long> lastUsageDates = Collections
                .synchronizedMap(new HashMap<File, Long>());
        protected File cacheDir;

        private ACacheManager(File cacheDir, long sizeLimit, int countLimit) {
            this.cacheDir = cacheDir;
            this.sizeLimit = sizeLimit;
            this.countLimit = countLimit;
            cacheSize = new AtomicLong();
            cacheCount = new AtomicInteger();
            calculateCacheSizeAndCacheCount();
        }

        /**
         * è®¡ç®— cacheSizeå’ŒcacheCount
         */
        private void calculateCacheSizeAndCacheCount() {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int size = 0;
                    int count = 0;
                    File[] cachedFiles = cacheDir.listFiles();
                    if (cachedFiles != null) {
                        for (File cachedFile : cachedFiles) {
                            size += calculateSize(cachedFile);
                            count += 1;
                            lastUsageDates.put(cachedFile,
                                    cachedFile.lastModified());
                        }
                        cacheSize.set(size);
                        cacheCount.set(count);
                    }
                }
            }).start();
        }

        private void put(File file) {
            int curCacheCount = cacheCount.get();
            while (curCacheCount + 1 > countLimit) {
                long freedSize = removeNext();
                cacheSize.addAndGet(-freedSize);

                curCacheCount = cacheCount.addAndGet(-1);
            }
            cacheCount.addAndGet(1);

            long valueSize = calculateSize(file);
            long curCacheSize = cacheSize.get();
            while (curCacheSize + valueSize > sizeLimit) {
                long freedSize = removeNext();
                curCacheSize = cacheSize.addAndGet(-freedSize);
            }
            cacheSize.addAndGet(valueSize);

            Long currentTime = System.currentTimeMillis();
            file.setLastModified(currentTime);
            lastUsageDates.put(file, currentTime);
        }

        private File get(String key) {
            File file = newFile(key);
            Long currentTime = System.currentTimeMillis();
            file.setLastModified(currentTime);
            lastUsageDates.put(file, currentTime);

            return file;
        }

        private File newFile(String key) {
            return new File(cacheDir, key.hashCode() + "");
        }

        private boolean remove(String key) {
            File image = get(key);
            return image.delete();
        }

        private void clear() {
            lastUsageDates.clear();
            cacheSize.set(0);
            File[] files = cacheDir.listFiles();
            if (files != null) {
                for (File f : files) {
                    f.delete();
                }
            }
        }

        /**
         * ç§»é™¤æ—§çš„æ–‡ä»¶
         *
         * @return
         */
        private long removeNext() {
            if (lastUsageDates.isEmpty()) {
                return 0;
            }

            Long oldestUsage = null;
            File mostLongUsedFile = null;
            Set<Map.Entry<File, Long>> entries = lastUsageDates.entrySet();
            synchronized (lastUsageDates) {
                for (Map.Entry<File, Long> entry : entries) {
                    if (mostLongUsedFile == null) {
                        mostLongUsedFile = entry.getKey();
                        oldestUsage = entry.getValue();
                    } else {
                        Long lastValueUsage = entry.getValue();
                        if (lastValueUsage < oldestUsage) {
                            oldestUsage = lastValueUsage;
                            mostLongUsedFile = entry.getKey();
                        }
                    }
                }
            }

            long fileSize = calculateSize(mostLongUsedFile);
            if (mostLongUsedFile.delete()) {
                lastUsageDates.remove(mostLongUsedFile);
            }
            return fileSize;
        }

        private long calculateSize(File file) {
            return file.length();
        }
    }

    /**
     * @title æ—¶é—´è®¡ç®—å·¥å…·ç±?
     * @author æ¨ç¦æµ·ï¼ˆmichaelï¼?www.yangfuhai.com
     * @version 1.0
     */
    private static class Utils {

        /**
         * åˆ¤æ–­ç¼“å­˜çš„Stringæ•°æ®æ˜¯å¦åˆ°æœŸ
         *
         * @param str
         * @return trueï¼šåˆ°æœŸäº† falseï¼šè¿˜æ²¡æœ‰åˆ°æœŸ
         */
        private static boolean isDue(String str) {
            return isDue(str.getBytes());
        }

        /**
         * åˆ¤æ–­ç¼“å­˜çš„byteæ•°æ®æ˜¯å¦åˆ°æœŸ
         *
         * @param data
         * @return trueï¼šåˆ°æœŸäº† falseï¼šè¿˜æ²¡æœ‰åˆ°æœŸ
         */
        private static boolean isDue(byte[] data) {
            String[] strs = getDateInfoFromDate(data);
            if (strs != null && strs.length == 2) {
                String saveTimeStr = strs[0];
                while (saveTimeStr.startsWith("0")) {
                    saveTimeStr = saveTimeStr
                            .substring(1, saveTimeStr.length());
                }
                long saveTime = Long.valueOf(saveTimeStr);
                long deleteAfter = Long.valueOf(strs[1]);
                if (System.currentTimeMillis() > saveTime + deleteAfter * 1000) {
                    return true;
                }
            }
            return false;
        }

        private static String newStringWithDateInfo(int second, String strInfo) {
            return createDateInfo(second) + strInfo;
        }

        private static byte[] newByteArrayWithDateInfo(int second, byte[] data2) {
            byte[] data1 = createDateInfo(second).getBytes();
            byte[] retdata = new byte[data1.length + data2.length];
            System.arraycopy(data1, 0, retdata, 0, data1.length);
            System.arraycopy(data2, 0, retdata, data1.length, data2.length);
            return retdata;
        }

        private static String clearDateInfo(String strInfo) {
            if (strInfo != null && hasDateInfo(strInfo.getBytes())) {
                strInfo = strInfo.substring(strInfo.indexOf(mSeparator) + 1,
                        strInfo.length());
            }
            return strInfo;
        }

        private static byte[] clearDateInfo(byte[] data) {
            if (hasDateInfo(data)) {
                return copyOfRange(data, indexOf(data, mSeparator) + 1,
                        data.length);
            }
            return data;
        }

        private static boolean hasDateInfo(byte[] data) {
            return data != null && data.length > 15 && data[13] == '-'
                    && indexOf(data, mSeparator) > 14;
        }

        private static String[] getDateInfoFromDate(byte[] data) {
            if (hasDateInfo(data)) {
                String saveDate = new String(copyOfRange(data, 0, 13));
                String deleteAfter = new String(copyOfRange(data, 14,
                        indexOf(data, mSeparator)));
                return new String[] { saveDate, deleteAfter };
            }
            return null;
        }

        private static int indexOf(byte[] data, char c) {
            for (int i = 0; i < data.length; i++) {
                if (data[i] == c) {
                    return i;
                }
            }
            return -1;
        }

        private static byte[] copyOfRange(byte[] original, int from, int to) {
            int newLength = to - from;
            if (newLength < 0)
                throw new IllegalArgumentException(from + " > " + to);
            byte[] copy = new byte[newLength];
            System.arraycopy(original, from, copy, 0,
                    Math.min(original.length - from, newLength));
            return copy;
        }

        private static final char mSeparator = ' ';

        private static String createDateInfo(int second) {
            String currentTime = System.currentTimeMillis() + "";
            while (currentTime.length() < 13) {
                currentTime = "0" + currentTime;
            }
            return currentTime + "-" + second + mSeparator;
        }

        /*
         * Bitmap â†?byte[]
         */
        private static byte[] Bitmap2Bytes(Bitmap bm) {
            if (bm == null) {
                return null;
            }
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bm.compress(Bitmap.CompressFormat.PNG, 100, baos);
            return baos.toByteArray();
        }

        /*
         * byte[] â†?Bitmap
         */
        private static Bitmap Bytes2Bimap(byte[] b) {
            if (b.length == 0) {
                return null;
            }
            return BitmapFactory.decodeByteArray(b, 0, b.length);
        }

        /*
         * Drawable â†?Bitmap
         */
        private static Bitmap drawable2Bitmap(Drawable drawable) {
            if (drawable == null) {
                return null;
            }
            // å?drawable çš„é•¿å®?
            int w = drawable.getIntrinsicWidth();
            int h = drawable.getIntrinsicHeight();
            // å?drawable çš„é¢œè‰²æ ¼å¼?
            Bitmap.Config config = drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
                    : Bitmap.Config.RGB_565;
            // å»ºç«‹å¯¹åº” bitmap
            Bitmap bitmap = Bitmap.createBitmap(w, h, config);
            // å»ºç«‹å¯¹åº” bitmap çš„ç”»å¸?
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, w, h);
            // æŠ?drawable å†…å®¹ç”»åˆ°ç”»å¸ƒä¸?
            drawable.draw(canvas);
            return bitmap;
        }

        /*
         * Bitmap â†?Drawable
         */
        @SuppressWarnings("deprecation")
        private static Drawable bitmap2Drawable(Bitmap bm) {
            if (bm == null) {
                return null;
            }
            return new BitmapDrawable(bm);
        }
    }


}
