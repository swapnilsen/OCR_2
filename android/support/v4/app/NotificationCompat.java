package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.app.NotificationCompatBase.Action.Factory;
import android.support.v4.app.NotificationCompatBase.UnreadConversation;
import android.support.v4.app.RemoteInputCompatBase.RemoteInput;
import android.support.v4.os.BuildCompat;
import android.widget.RemoteViews;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class NotificationCompat {
    public static final String CATEGORY_ALARM = "alarm";
    public static final String CATEGORY_CALL = "call";
    public static final String CATEGORY_EMAIL = "email";
    public static final String CATEGORY_ERROR = "err";
    public static final String CATEGORY_EVENT = "event";
    public static final String CATEGORY_MESSAGE = "msg";
    public static final String CATEGORY_PROGRESS = "progress";
    public static final String CATEGORY_PROMO = "promo";
    public static final String CATEGORY_RECOMMENDATION = "recommendation";
    public static final String CATEGORY_REMINDER = "reminder";
    public static final String CATEGORY_SERVICE = "service";
    public static final String CATEGORY_SOCIAL = "social";
    public static final String CATEGORY_STATUS = "status";
    public static final String CATEGORY_SYSTEM = "sys";
    public static final String CATEGORY_TRANSPORT = "transport";
    @ColorInt
    public static final int COLOR_DEFAULT = 0;
    public static final int DEFAULT_ALL = -1;
    public static final int DEFAULT_LIGHTS = 4;
    public static final int DEFAULT_SOUND = 1;
    public static final int DEFAULT_VIBRATE = 2;
    public static final String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";
    public static final String EXTRA_BIG_TEXT = "android.bigText";
    public static final String EXTRA_COMPACT_ACTIONS = "android.compactActions";
    public static final String EXTRA_CONVERSATION_TITLE = "android.conversationTitle";
    public static final String EXTRA_INFO_TEXT = "android.infoText";
    public static final String EXTRA_LARGE_ICON = "android.largeIcon";
    public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";
    public static final String EXTRA_MEDIA_SESSION = "android.mediaSession";
    public static final String EXTRA_MESSAGES = "android.messages";
    public static final String EXTRA_PEOPLE = "android.people";
    public static final String EXTRA_PICTURE = "android.picture";
    public static final String EXTRA_PROGRESS = "android.progress";
    public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";
    public static final String EXTRA_PROGRESS_MAX = "android.progressMax";
    public static final String EXTRA_REMOTE_INPUT_HISTORY = "android.remoteInputHistory";
    public static final String EXTRA_SELF_DISPLAY_NAME = "android.selfDisplayName";
    public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";
    public static final String EXTRA_SHOW_WHEN = "android.showWhen";
    public static final String EXTRA_SMALL_ICON = "android.icon";
    public static final String EXTRA_SUB_TEXT = "android.subText";
    public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";
    public static final String EXTRA_TEMPLATE = "android.template";
    public static final String EXTRA_TEXT = "android.text";
    public static final String EXTRA_TEXT_LINES = "android.textLines";
    public static final String EXTRA_TITLE = "android.title";
    public static final String EXTRA_TITLE_BIG = "android.title.big";
    public static final int FLAG_AUTO_CANCEL = 16;
    public static final int FLAG_FOREGROUND_SERVICE = 64;
    public static final int FLAG_GROUP_SUMMARY = 512;
    @Deprecated
    public static final int FLAG_HIGH_PRIORITY = 128;
    public static final int FLAG_INSISTENT = 4;
    public static final int FLAG_LOCAL_ONLY = 256;
    public static final int FLAG_NO_CLEAR = 32;
    public static final int FLAG_ONGOING_EVENT = 2;
    public static final int FLAG_ONLY_ALERT_ONCE = 8;
    public static final int FLAG_SHOW_LIGHTS = 1;
    static final NotificationCompatImpl IMPL;
    public static final int PRIORITY_DEFAULT = 0;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_LOW = -1;
    public static final int PRIORITY_MAX = 2;
    public static final int PRIORITY_MIN = -2;
    public static final int STREAM_DEFAULT = -1;
    public static final int VISIBILITY_PRIVATE = 0;
    public static final int VISIBILITY_PUBLIC = 1;
    public static final int VISIBILITY_SECRET = -1;

    public static class Action extends android.support.v4.app.NotificationCompatBase.Action {
        @RestrictTo({Scope.LIBRARY_GROUP})
        public static final Factory FACTORY;
        public PendingIntent actionIntent;
        public int icon;
        private boolean mAllowGeneratedReplies;
        final Bundle mExtras;
        private final RemoteInput[] mRemoteInputs;
        public CharSequence title;

        /* renamed from: android.support.v4.app.NotificationCompat.Action.1 */
        static class C01071 implements Factory {
            C01071() {
            }

            public android.support.v4.app.NotificationCompatBase.Action build(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr, boolean z) {
                return new Action(i, charSequence, pendingIntent, bundle, (RemoteInput[]) remoteInputArr, z);
            }

            public Action[] newArray(int i) {
                return new Action[i];
            }
        }

        public static final class Builder {
            private boolean mAllowGeneratedReplies;
            private final Bundle mExtras;
            private final int mIcon;
            private final PendingIntent mIntent;
            private ArrayList<RemoteInput> mRemoteInputs;
            private final CharSequence mTitle;

            public Builder(int i, CharSequence charSequence, PendingIntent pendingIntent) {
                this(i, charSequence, pendingIntent, new Bundle(), null, true);
            }

            public Builder(Action action) {
                this(action.icon, action.title, action.actionIntent, new Bundle(action.mExtras), action.getRemoteInputs(), action.getAllowGeneratedReplies());
            }

            private Builder(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr, boolean z) {
                ArrayList arrayList;
                this.mAllowGeneratedReplies = true;
                this.mIcon = i;
                this.mTitle = Builder.limitCharSequenceLength(charSequence);
                this.mIntent = pendingIntent;
                this.mExtras = bundle;
                if (remoteInputArr == null) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList(Arrays.asList(remoteInputArr));
                }
                this.mRemoteInputs = arrayList;
                this.mAllowGeneratedReplies = z;
            }

            public Builder addExtras(Bundle bundle) {
                if (bundle != null) {
                    this.mExtras.putAll(bundle);
                }
                return this;
            }

            public Bundle getExtras() {
                return this.mExtras;
            }

            public Builder addRemoteInput(RemoteInput remoteInput) {
                if (this.mRemoteInputs == null) {
                    this.mRemoteInputs = new ArrayList();
                }
                this.mRemoteInputs.add(remoteInput);
                return this;
            }

            public Builder setAllowGeneratedReplies(boolean z) {
                this.mAllowGeneratedReplies = z;
                return this;
            }

            public Builder extend(Extender extender) {
                extender.extend(this);
                return this;
            }

            public Action build() {
                return new Action(this.mIcon, this.mTitle, this.mIntent, this.mExtras, this.mRemoteInputs != null ? (RemoteInput[]) this.mRemoteInputs.toArray(new RemoteInput[this.mRemoteInputs.size()]) : null, this.mAllowGeneratedReplies);
            }
        }

        public interface Extender {
            Builder extend(Builder builder);
        }

        public static final class WearableExtender implements Extender {
            private static final int DEFAULT_FLAGS = 1;
            private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
            private static final int FLAG_AVAILABLE_OFFLINE = 1;
            private static final int FLAG_HINT_DISPLAY_INLINE = 4;
            private static final int FLAG_HINT_LAUNCHES_ACTIVITY = 2;
            private static final String KEY_CANCEL_LABEL = "cancelLabel";
            private static final String KEY_CONFIRM_LABEL = "confirmLabel";
            private static final String KEY_FLAGS = "flags";
            private static final String KEY_IN_PROGRESS_LABEL = "inProgressLabel";
            private CharSequence mCancelLabel;
            private CharSequence mConfirmLabel;
            private int mFlags;
            private CharSequence mInProgressLabel;

            public WearableExtender() {
                this.mFlags = FLAG_AVAILABLE_OFFLINE;
            }

            public WearableExtender(Action action) {
                this.mFlags = FLAG_AVAILABLE_OFFLINE;
                Bundle bundle = action.getExtras().getBundle(EXTRA_WEARABLE_EXTENSIONS);
                if (bundle != null) {
                    this.mFlags = bundle.getInt(KEY_FLAGS, FLAG_AVAILABLE_OFFLINE);
                    this.mInProgressLabel = bundle.getCharSequence(KEY_IN_PROGRESS_LABEL);
                    this.mConfirmLabel = bundle.getCharSequence(KEY_CONFIRM_LABEL);
                    this.mCancelLabel = bundle.getCharSequence(KEY_CANCEL_LABEL);
                }
            }

            public Builder extend(Builder builder) {
                Bundle bundle = new Bundle();
                if (this.mFlags != FLAG_AVAILABLE_OFFLINE) {
                    bundle.putInt(KEY_FLAGS, this.mFlags);
                }
                if (this.mInProgressLabel != null) {
                    bundle.putCharSequence(KEY_IN_PROGRESS_LABEL, this.mInProgressLabel);
                }
                if (this.mConfirmLabel != null) {
                    bundle.putCharSequence(KEY_CONFIRM_LABEL, this.mConfirmLabel);
                }
                if (this.mCancelLabel != null) {
                    bundle.putCharSequence(KEY_CANCEL_LABEL, this.mCancelLabel);
                }
                builder.getExtras().putBundle(EXTRA_WEARABLE_EXTENSIONS, bundle);
                return builder;
            }

            public WearableExtender clone() {
                WearableExtender wearableExtender = new WearableExtender();
                wearableExtender.mFlags = this.mFlags;
                wearableExtender.mInProgressLabel = this.mInProgressLabel;
                wearableExtender.mConfirmLabel = this.mConfirmLabel;
                wearableExtender.mCancelLabel = this.mCancelLabel;
                return wearableExtender;
            }

            public WearableExtender setAvailableOffline(boolean z) {
                setFlag(FLAG_AVAILABLE_OFFLINE, z);
                return this;
            }

            public boolean isAvailableOffline() {
                return (this.mFlags & FLAG_AVAILABLE_OFFLINE) != 0;
            }

            private void setFlag(int i, boolean z) {
                if (z) {
                    this.mFlags |= i;
                } else {
                    this.mFlags &= i ^ NotificationCompat.VISIBILITY_SECRET;
                }
            }

            public WearableExtender setInProgressLabel(CharSequence charSequence) {
                this.mInProgressLabel = charSequence;
                return this;
            }

            public CharSequence getInProgressLabel() {
                return this.mInProgressLabel;
            }

            public WearableExtender setConfirmLabel(CharSequence charSequence) {
                this.mConfirmLabel = charSequence;
                return this;
            }

            public CharSequence getConfirmLabel() {
                return this.mConfirmLabel;
            }

            public WearableExtender setCancelLabel(CharSequence charSequence) {
                this.mCancelLabel = charSequence;
                return this;
            }

            public CharSequence getCancelLabel() {
                return this.mCancelLabel;
            }

            public WearableExtender setHintLaunchesActivity(boolean z) {
                setFlag(FLAG_HINT_LAUNCHES_ACTIVITY, z);
                return this;
            }

            public boolean getHintLaunchesActivity() {
                return (this.mFlags & FLAG_HINT_LAUNCHES_ACTIVITY) != 0;
            }

            public WearableExtender setHintDisplayActionInline(boolean z) {
                setFlag(FLAG_HINT_DISPLAY_INLINE, z);
                return this;
            }

            public boolean getHintDisplayActionInline() {
                return (this.mFlags & FLAG_HINT_DISPLAY_INLINE) != 0;
            }
        }

        public Action(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i, charSequence, pendingIntent, new Bundle(), null, true);
        }

        Action(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr, boolean z) {
            this.icon = i;
            this.title = Builder.limitCharSequenceLength(charSequence);
            this.actionIntent = pendingIntent;
            if (bundle == null) {
                bundle = new Bundle();
            }
            this.mExtras = bundle;
            this.mRemoteInputs = remoteInputArr;
            this.mAllowGeneratedReplies = z;
        }

        public int getIcon() {
            return this.icon;
        }

        public CharSequence getTitle() {
            return this.title;
        }

        public PendingIntent getActionIntent() {
            return this.actionIntent;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public boolean getAllowGeneratedReplies() {
            return this.mAllowGeneratedReplies;
        }

        public RemoteInput[] getRemoteInputs() {
            return this.mRemoteInputs;
        }

        static {
            FACTORY = new C01071();
        }
    }

    public static abstract class Style {
        CharSequence mBigContentTitle;
        Builder mBuilder;
        CharSequence mSummaryText;
        boolean mSummaryTextSet;

        public Style() {
            this.mSummaryTextSet = false;
        }

        public void setBuilder(Builder builder) {
            if (this.mBuilder != builder) {
                this.mBuilder = builder;
                if (this.mBuilder != null) {
                    this.mBuilder.setStyle(this);
                }
            }
        }

        public Notification build() {
            if (this.mBuilder != null) {
                return this.mBuilder.build();
            }
            return null;
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        public void addCompatExtras(Bundle bundle) {
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        protected void restoreFromCompatExtras(Bundle bundle) {
        }
    }

    public static class BigPictureStyle extends Style {
        Bitmap mBigLargeIcon;
        boolean mBigLargeIconSet;
        Bitmap mPicture;

        public BigPictureStyle(Builder builder) {
            setBuilder(builder);
        }

        public BigPictureStyle setBigContentTitle(CharSequence charSequence) {
            this.mBigContentTitle = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        public BigPictureStyle setSummaryText(CharSequence charSequence) {
            this.mSummaryText = Builder.limitCharSequenceLength(charSequence);
            this.mSummaryTextSet = true;
            return this;
        }

        public BigPictureStyle bigPicture(Bitmap bitmap) {
            this.mPicture = bitmap;
            return this;
        }

        public BigPictureStyle bigLargeIcon(Bitmap bitmap) {
            this.mBigLargeIcon = bitmap;
            this.mBigLargeIconSet = true;
            return this;
        }
    }

    public static class BigTextStyle extends Style {
        CharSequence mBigText;

        public BigTextStyle(Builder builder) {
            setBuilder(builder);
        }

        public BigTextStyle setBigContentTitle(CharSequence charSequence) {
            this.mBigContentTitle = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        public BigTextStyle setSummaryText(CharSequence charSequence) {
            this.mSummaryText = Builder.limitCharSequenceLength(charSequence);
            this.mSummaryTextSet = true;
            return this;
        }

        public BigTextStyle bigText(CharSequence charSequence) {
            this.mBigText = Builder.limitCharSequenceLength(charSequence);
            return this;
        }
    }

    public static class Builder {
        private static final int MAX_CHARSEQUENCE_LENGTH = 5120;
        @RestrictTo({Scope.LIBRARY_GROUP})
        public ArrayList<Action> mActions;
        RemoteViews mBigContentView;
        String mCategory;
        int mColor;
        @RestrictTo({Scope.LIBRARY_GROUP})
        public CharSequence mContentInfo;
        PendingIntent mContentIntent;
        @RestrictTo({Scope.LIBRARY_GROUP})
        public CharSequence mContentText;
        @RestrictTo({Scope.LIBRARY_GROUP})
        public CharSequence mContentTitle;
        RemoteViews mContentView;
        @RestrictTo({Scope.LIBRARY_GROUP})
        public Context mContext;
        Bundle mExtras;
        PendingIntent mFullScreenIntent;
        String mGroupKey;
        boolean mGroupSummary;
        RemoteViews mHeadsUpContentView;
        @RestrictTo({Scope.LIBRARY_GROUP})
        public Bitmap mLargeIcon;
        boolean mLocalOnly;
        @RestrictTo({Scope.LIBRARY_GROUP})
        public Notification mNotification;
        @RestrictTo({Scope.LIBRARY_GROUP})
        public int mNumber;
        public ArrayList<String> mPeople;
        int mPriority;
        int mProgress;
        boolean mProgressIndeterminate;
        int mProgressMax;
        Notification mPublicVersion;
        @RestrictTo({Scope.LIBRARY_GROUP})
        public CharSequence[] mRemoteInputHistory;
        boolean mShowWhen;
        String mSortKey;
        @RestrictTo({Scope.LIBRARY_GROUP})
        public Style mStyle;
        @RestrictTo({Scope.LIBRARY_GROUP})
        public CharSequence mSubText;
        RemoteViews mTickerView;
        @RestrictTo({Scope.LIBRARY_GROUP})
        public boolean mUseChronometer;
        int mVisibility;

        public Builder(Context context) {
            this.mShowWhen = true;
            this.mActions = new ArrayList();
            this.mLocalOnly = false;
            this.mColor = NotificationCompat.VISIBILITY_PRIVATE;
            this.mVisibility = NotificationCompat.VISIBILITY_PRIVATE;
            this.mNotification = new Notification();
            this.mContext = context;
            this.mNotification.when = System.currentTimeMillis();
            this.mNotification.audioStreamType = NotificationCompat.VISIBILITY_SECRET;
            this.mPriority = NotificationCompat.VISIBILITY_PRIVATE;
            this.mPeople = new ArrayList();
        }

        public Builder setWhen(long j) {
            this.mNotification.when = j;
            return this;
        }

        public Builder setShowWhen(boolean z) {
            this.mShowWhen = z;
            return this;
        }

        public Builder setUsesChronometer(boolean z) {
            this.mUseChronometer = z;
            return this;
        }

        public Builder setSmallIcon(int i) {
            this.mNotification.icon = i;
            return this;
        }

        public Builder setSmallIcon(int i, int i2) {
            this.mNotification.icon = i;
            this.mNotification.iconLevel = i2;
            return this;
        }

        public Builder setContentTitle(CharSequence charSequence) {
            this.mContentTitle = limitCharSequenceLength(charSequence);
            return this;
        }

        public Builder setContentText(CharSequence charSequence) {
            this.mContentText = limitCharSequenceLength(charSequence);
            return this;
        }

        public Builder setSubText(CharSequence charSequence) {
            this.mSubText = limitCharSequenceLength(charSequence);
            return this;
        }

        public Builder setRemoteInputHistory(CharSequence[] charSequenceArr) {
            this.mRemoteInputHistory = charSequenceArr;
            return this;
        }

        public Builder setNumber(int i) {
            this.mNumber = i;
            return this;
        }

        public Builder setContentInfo(CharSequence charSequence) {
            this.mContentInfo = limitCharSequenceLength(charSequence);
            return this;
        }

        public Builder setProgress(int i, int i2, boolean z) {
            this.mProgressMax = i;
            this.mProgress = i2;
            this.mProgressIndeterminate = z;
            return this;
        }

        public Builder setContent(RemoteViews remoteViews) {
            this.mNotification.contentView = remoteViews;
            return this;
        }

        public Builder setContentIntent(PendingIntent pendingIntent) {
            this.mContentIntent = pendingIntent;
            return this;
        }

        public Builder setDeleteIntent(PendingIntent pendingIntent) {
            this.mNotification.deleteIntent = pendingIntent;
            return this;
        }

        public Builder setFullScreenIntent(PendingIntent pendingIntent, boolean z) {
            this.mFullScreenIntent = pendingIntent;
            setFlag(NotificationCompat.FLAG_HIGH_PRIORITY, z);
            return this;
        }

        public Builder setTicker(CharSequence charSequence) {
            this.mNotification.tickerText = limitCharSequenceLength(charSequence);
            return this;
        }

        public Builder setTicker(CharSequence charSequence, RemoteViews remoteViews) {
            this.mNotification.tickerText = limitCharSequenceLength(charSequence);
            this.mTickerView = remoteViews;
            return this;
        }

        public Builder setLargeIcon(Bitmap bitmap) {
            this.mLargeIcon = bitmap;
            return this;
        }

        public Builder setSound(Uri uri) {
            this.mNotification.sound = uri;
            this.mNotification.audioStreamType = NotificationCompat.VISIBILITY_SECRET;
            return this;
        }

        public Builder setSound(Uri uri, int i) {
            this.mNotification.sound = uri;
            this.mNotification.audioStreamType = i;
            return this;
        }

        public Builder setVibrate(long[] jArr) {
            this.mNotification.vibrate = jArr;
            return this;
        }

        public Builder setLights(@ColorInt int i, int i2, int i3) {
            int i4;
            int i5 = NotificationCompat.VISIBILITY_PUBLIC;
            this.mNotification.ledARGB = i;
            this.mNotification.ledOnMS = i2;
            this.mNotification.ledOffMS = i3;
            if (this.mNotification.ledOnMS == 0 || this.mNotification.ledOffMS == 0) {
                i4 = NotificationCompat.VISIBILITY_PRIVATE;
            } else {
                i4 = NotificationCompat.VISIBILITY_PUBLIC;
            }
            Notification notification = this.mNotification;
            int i6 = this.mNotification.flags & NotificationCompat.PRIORITY_MIN;
            if (i4 == 0) {
                i5 = NotificationCompat.VISIBILITY_PRIVATE;
            }
            notification.flags = i6 | i5;
            return this;
        }

        public Builder setOngoing(boolean z) {
            setFlag(NotificationCompat.PRIORITY_MAX, z);
            return this;
        }

        public Builder setOnlyAlertOnce(boolean z) {
            setFlag(NotificationCompat.FLAG_ONLY_ALERT_ONCE, z);
            return this;
        }

        public Builder setAutoCancel(boolean z) {
            setFlag(NotificationCompat.FLAG_AUTO_CANCEL, z);
            return this;
        }

        public Builder setLocalOnly(boolean z) {
            this.mLocalOnly = z;
            return this;
        }

        public Builder setCategory(String str) {
            this.mCategory = str;
            return this;
        }

        public Builder setDefaults(int i) {
            this.mNotification.defaults = i;
            if ((i & NotificationCompat.FLAG_INSISTENT) != 0) {
                Notification notification = this.mNotification;
                notification.flags |= NotificationCompat.VISIBILITY_PUBLIC;
            }
            return this;
        }

        private void setFlag(int i, boolean z) {
            if (z) {
                Notification notification = this.mNotification;
                notification.flags |= i;
                return;
            }
            notification = this.mNotification;
            notification.flags &= i ^ NotificationCompat.VISIBILITY_SECRET;
        }

        public Builder setPriority(int i) {
            this.mPriority = i;
            return this;
        }

        public Builder addPerson(String str) {
            this.mPeople.add(str);
            return this;
        }

        public Builder setGroup(String str) {
            this.mGroupKey = str;
            return this;
        }

        public Builder setGroupSummary(boolean z) {
            this.mGroupSummary = z;
            return this;
        }

        public Builder setSortKey(String str) {
            this.mSortKey = str;
            return this;
        }

        public Builder addExtras(Bundle bundle) {
            if (bundle != null) {
                if (this.mExtras == null) {
                    this.mExtras = new Bundle(bundle);
                } else {
                    this.mExtras.putAll(bundle);
                }
            }
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.mExtras = bundle;
            return this;
        }

        public Bundle getExtras() {
            if (this.mExtras == null) {
                this.mExtras = new Bundle();
            }
            return this.mExtras;
        }

        public Builder addAction(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this.mActions.add(new Action(i, charSequence, pendingIntent));
            return this;
        }

        public Builder addAction(Action action) {
            this.mActions.add(action);
            return this;
        }

        public Builder setStyle(Style style) {
            if (this.mStyle != style) {
                this.mStyle = style;
                if (this.mStyle != null) {
                    this.mStyle.setBuilder(this);
                }
            }
            return this;
        }

        public Builder setColor(@ColorInt int i) {
            this.mColor = i;
            return this;
        }

        public Builder setVisibility(int i) {
            this.mVisibility = i;
            return this;
        }

        public Builder setPublicVersion(Notification notification) {
            this.mPublicVersion = notification;
            return this;
        }

        public Builder setCustomContentView(RemoteViews remoteViews) {
            this.mContentView = remoteViews;
            return this;
        }

        public Builder setCustomBigContentView(RemoteViews remoteViews) {
            this.mBigContentView = remoteViews;
            return this;
        }

        public Builder setCustomHeadsUpContentView(RemoteViews remoteViews) {
            this.mHeadsUpContentView = remoteViews;
            return this;
        }

        public Builder extend(Extender extender) {
            extender.extend(this);
            return this;
        }

        @Deprecated
        public Notification getNotification() {
            return build();
        }

        public Notification build() {
            return NotificationCompat.IMPL.build(this, getExtender());
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        protected BuilderExtender getExtender() {
            return new BuilderExtender();
        }

        protected static CharSequence limitCharSequenceLength(CharSequence charSequence) {
            if (charSequence != null && charSequence.length() > MAX_CHARSEQUENCE_LENGTH) {
                return charSequence.subSequence(NotificationCompat.VISIBILITY_PRIVATE, MAX_CHARSEQUENCE_LENGTH);
            }
            return charSequence;
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        public RemoteViews getContentView() {
            return this.mContentView;
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        public RemoteViews getBigContentView() {
            return this.mBigContentView;
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        public RemoteViews getHeadsUpContentView() {
            return this.mHeadsUpContentView;
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        public long getWhenIfShowing() {
            return this.mShowWhen ? this.mNotification.when : 0;
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        public int getPriority() {
            return this.mPriority;
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        public int getColor() {
            return this.mColor;
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        protected CharSequence resolveText() {
            return this.mContentText;
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        protected CharSequence resolveTitle() {
            return this.mContentTitle;
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    protected static class BuilderExtender {
        protected BuilderExtender() {
        }

        public Notification build(Builder builder, NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            Notification build = notificationBuilderWithBuilderAccessor.build();
            if (builder.mContentView != null) {
                build.contentView = builder.mContentView;
            }
            return build;
        }
    }

    public interface Extender {
        Builder extend(Builder builder);
    }

    public static final class CarExtender implements Extender {
        private static final String EXTRA_CAR_EXTENDER = "android.car.EXTENSIONS";
        private static final String EXTRA_COLOR = "app_color";
        private static final String EXTRA_CONVERSATION = "car_conversation";
        private static final String EXTRA_LARGE_ICON = "large_icon";
        private static final String TAG = "CarExtender";
        private int mColor;
        private Bitmap mLargeIcon;
        private UnreadConversation mUnreadConversation;

        public static class UnreadConversation extends android.support.v4.app.NotificationCompatBase.UnreadConversation {
            static final android.support.v4.app.NotificationCompatBase.UnreadConversation.Factory FACTORY;
            private final long mLatestTimestamp;
            private final String[] mMessages;
            private final String[] mParticipants;
            private final PendingIntent mReadPendingIntent;
            private final RemoteInput mRemoteInput;
            private final PendingIntent mReplyPendingIntent;

            /* renamed from: android.support.v4.app.NotificationCompat.CarExtender.UnreadConversation.1 */
            static class C01081 implements android.support.v4.app.NotificationCompatBase.UnreadConversation.Factory {
                C01081() {
                }

                public UnreadConversation build(String[] strArr, RemoteInput remoteInput, PendingIntent pendingIntent, PendingIntent pendingIntent2, String[] strArr2, long j) {
                    return new UnreadConversation(strArr, (RemoteInput) remoteInput, pendingIntent, pendingIntent2, strArr2, j);
                }
            }

            public static class Builder {
                private long mLatestTimestamp;
                private final List<String> mMessages;
                private final String mParticipant;
                private PendingIntent mReadPendingIntent;
                private RemoteInput mRemoteInput;
                private PendingIntent mReplyPendingIntent;

                public Builder(String str) {
                    this.mMessages = new ArrayList();
                    this.mParticipant = str;
                }

                public Builder addMessage(String str) {
                    this.mMessages.add(str);
                    return this;
                }

                public Builder setReplyAction(PendingIntent pendingIntent, RemoteInput remoteInput) {
                    this.mRemoteInput = remoteInput;
                    this.mReplyPendingIntent = pendingIntent;
                    return this;
                }

                public Builder setReadPendingIntent(PendingIntent pendingIntent) {
                    this.mReadPendingIntent = pendingIntent;
                    return this;
                }

                public Builder setLatestTimestamp(long j) {
                    this.mLatestTimestamp = j;
                    return this;
                }

                public UnreadConversation build() {
                    String[] strArr = (String[]) this.mMessages.toArray(new String[this.mMessages.size()]);
                    String[] strArr2 = new String[NotificationCompat.VISIBILITY_PUBLIC];
                    strArr2[NotificationCompat.VISIBILITY_PRIVATE] = this.mParticipant;
                    return new UnreadConversation(strArr, this.mRemoteInput, this.mReplyPendingIntent, this.mReadPendingIntent, strArr2, this.mLatestTimestamp);
                }
            }

            UnreadConversation(String[] strArr, RemoteInput remoteInput, PendingIntent pendingIntent, PendingIntent pendingIntent2, String[] strArr2, long j) {
                this.mMessages = strArr;
                this.mRemoteInput = remoteInput;
                this.mReadPendingIntent = pendingIntent2;
                this.mReplyPendingIntent = pendingIntent;
                this.mParticipants = strArr2;
                this.mLatestTimestamp = j;
            }

            public String[] getMessages() {
                return this.mMessages;
            }

            public RemoteInput getRemoteInput() {
                return this.mRemoteInput;
            }

            public PendingIntent getReplyPendingIntent() {
                return this.mReplyPendingIntent;
            }

            public PendingIntent getReadPendingIntent() {
                return this.mReadPendingIntent;
            }

            public String[] getParticipants() {
                return this.mParticipants;
            }

            public String getParticipant() {
                return this.mParticipants.length > 0 ? this.mParticipants[NotificationCompat.VISIBILITY_PRIVATE] : null;
            }

            public long getLatestTimestamp() {
                return this.mLatestTimestamp;
            }

            static {
                FACTORY = new C01081();
            }
        }

        public CarExtender() {
            this.mColor = NotificationCompat.VISIBILITY_PRIVATE;
        }

        public CarExtender(Notification notification) {
            this.mColor = NotificationCompat.VISIBILITY_PRIVATE;
            if (VERSION.SDK_INT >= 21) {
                Bundle bundle;
                if (NotificationCompat.getExtras(notification) == null) {
                    bundle = null;
                } else {
                    bundle = NotificationCompat.getExtras(notification).getBundle(EXTRA_CAR_EXTENDER);
                }
                if (bundle != null) {
                    this.mLargeIcon = (Bitmap) bundle.getParcelable(EXTRA_LARGE_ICON);
                    this.mColor = bundle.getInt(EXTRA_COLOR, NotificationCompat.VISIBILITY_PRIVATE);
                    this.mUnreadConversation = (UnreadConversation) NotificationCompat.IMPL.getUnreadConversationFromBundle(bundle.getBundle(EXTRA_CONVERSATION), UnreadConversation.FACTORY, RemoteInput.FACTORY);
                }
            }
        }

        public Builder extend(Builder builder) {
            if (VERSION.SDK_INT >= 21) {
                Bundle bundle = new Bundle();
                if (this.mLargeIcon != null) {
                    bundle.putParcelable(EXTRA_LARGE_ICON, this.mLargeIcon);
                }
                if (this.mColor != 0) {
                    bundle.putInt(EXTRA_COLOR, this.mColor);
                }
                if (this.mUnreadConversation != null) {
                    bundle.putBundle(EXTRA_CONVERSATION, NotificationCompat.IMPL.getBundleForUnreadConversation(this.mUnreadConversation));
                }
                builder.getExtras().putBundle(EXTRA_CAR_EXTENDER, bundle);
            }
            return builder;
        }

        public CarExtender setColor(@ColorInt int i) {
            this.mColor = i;
            return this;
        }

        @ColorInt
        public int getColor() {
            return this.mColor;
        }

        public CarExtender setLargeIcon(Bitmap bitmap) {
            this.mLargeIcon = bitmap;
            return this;
        }

        public Bitmap getLargeIcon() {
            return this.mLargeIcon;
        }

        public CarExtender setUnreadConversation(UnreadConversation unreadConversation) {
            this.mUnreadConversation = unreadConversation;
            return this;
        }

        public UnreadConversation getUnreadConversation() {
            return this.mUnreadConversation;
        }
    }

    public static class InboxStyle extends Style {
        ArrayList<CharSequence> mTexts;

        public InboxStyle() {
            this.mTexts = new ArrayList();
        }

        public InboxStyle(Builder builder) {
            this.mTexts = new ArrayList();
            setBuilder(builder);
        }

        public InboxStyle setBigContentTitle(CharSequence charSequence) {
            this.mBigContentTitle = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        public InboxStyle setSummaryText(CharSequence charSequence) {
            this.mSummaryText = Builder.limitCharSequenceLength(charSequence);
            this.mSummaryTextSet = true;
            return this;
        }

        public InboxStyle addLine(CharSequence charSequence) {
            this.mTexts.add(Builder.limitCharSequenceLength(charSequence));
            return this;
        }
    }

    public static class MessagingStyle extends Style {
        public static final int MAXIMUM_RETAINED_MESSAGES = 25;
        CharSequence mConversationTitle;
        List<Message> mMessages;
        CharSequence mUserDisplayName;

        public static final class Message {
            static final String KEY_DATA_MIME_TYPE = "type";
            static final String KEY_DATA_URI = "uri";
            static final String KEY_SENDER = "sender";
            static final String KEY_TEXT = "text";
            static final String KEY_TIMESTAMP = "time";
            private String mDataMimeType;
            private Uri mDataUri;
            private final CharSequence mSender;
            private final CharSequence mText;
            private final long mTimestamp;

            public Message(CharSequence charSequence, long j, CharSequence charSequence2) {
                this.mText = charSequence;
                this.mTimestamp = j;
                this.mSender = charSequence2;
            }

            public Message setData(String str, Uri uri) {
                this.mDataMimeType = str;
                this.mDataUri = uri;
                return this;
            }

            public CharSequence getText() {
                return this.mText;
            }

            public long getTimestamp() {
                return this.mTimestamp;
            }

            public CharSequence getSender() {
                return this.mSender;
            }

            public String getDataMimeType() {
                return this.mDataMimeType;
            }

            public Uri getDataUri() {
                return this.mDataUri;
            }

            private Bundle toBundle() {
                Bundle bundle = new Bundle();
                if (this.mText != null) {
                    bundle.putCharSequence(KEY_TEXT, this.mText);
                }
                bundle.putLong(KEY_TIMESTAMP, this.mTimestamp);
                if (this.mSender != null) {
                    bundle.putCharSequence(KEY_SENDER, this.mSender);
                }
                if (this.mDataMimeType != null) {
                    bundle.putString(KEY_DATA_MIME_TYPE, this.mDataMimeType);
                }
                if (this.mDataUri != null) {
                    bundle.putParcelable(KEY_DATA_URI, this.mDataUri);
                }
                return bundle;
            }

            static Bundle[] getBundleArrayForMessages(List<Message> list) {
                Bundle[] bundleArr = new Bundle[list.size()];
                int size = list.size();
                for (int i = NotificationCompat.VISIBILITY_PRIVATE; i < size; i += NotificationCompat.VISIBILITY_PUBLIC) {
                    bundleArr[i] = ((Message) list.get(i)).toBundle();
                }
                return bundleArr;
            }

            static List<Message> getMessagesFromBundleArray(Parcelable[] parcelableArr) {
                List<Message> arrayList = new ArrayList(parcelableArr.length);
                for (int i = NotificationCompat.VISIBILITY_PRIVATE; i < parcelableArr.length; i += NotificationCompat.VISIBILITY_PUBLIC) {
                    if (parcelableArr[i] instanceof Bundle) {
                        Message messageFromBundle = getMessageFromBundle((Bundle) parcelableArr[i]);
                        if (messageFromBundle != null) {
                            arrayList.add(messageFromBundle);
                        }
                    }
                }
                return arrayList;
            }

            static Message getMessageFromBundle(Bundle bundle) {
                try {
                    if (!bundle.containsKey(KEY_TEXT) || !bundle.containsKey(KEY_TIMESTAMP)) {
                        return null;
                    }
                    Message message = new Message(bundle.getCharSequence(KEY_TEXT), bundle.getLong(KEY_TIMESTAMP), bundle.getCharSequence(KEY_SENDER));
                    if (bundle.containsKey(KEY_DATA_MIME_TYPE) && bundle.containsKey(KEY_DATA_URI)) {
                        message.setData(bundle.getString(KEY_DATA_MIME_TYPE), (Uri) bundle.getParcelable(KEY_DATA_URI));
                    }
                    return message;
                } catch (ClassCastException e) {
                    return null;
                }
            }
        }

        MessagingStyle() {
            this.mMessages = new ArrayList();
        }

        public MessagingStyle(@NonNull CharSequence charSequence) {
            this.mMessages = new ArrayList();
            this.mUserDisplayName = charSequence;
        }

        public CharSequence getUserDisplayName() {
            return this.mUserDisplayName;
        }

        public MessagingStyle setConversationTitle(CharSequence charSequence) {
            this.mConversationTitle = charSequence;
            return this;
        }

        public CharSequence getConversationTitle() {
            return this.mConversationTitle;
        }

        public MessagingStyle addMessage(CharSequence charSequence, long j, CharSequence charSequence2) {
            this.mMessages.add(new Message(charSequence, j, charSequence2));
            if (this.mMessages.size() > MAXIMUM_RETAINED_MESSAGES) {
                this.mMessages.remove(NotificationCompat.VISIBILITY_PRIVATE);
            }
            return this;
        }

        public MessagingStyle addMessage(Message message) {
            this.mMessages.add(message);
            if (this.mMessages.size() > MAXIMUM_RETAINED_MESSAGES) {
                this.mMessages.remove(NotificationCompat.VISIBILITY_PRIVATE);
            }
            return this;
        }

        public List<Message> getMessages() {
            return this.mMessages;
        }

        public static MessagingStyle extractMessagingStyleFromNotification(Notification notification) {
            Bundle extras = NotificationCompat.IMPL.getExtras(notification);
            if (extras != null && !extras.containsKey(NotificationCompat.EXTRA_SELF_DISPLAY_NAME)) {
                return null;
            }
            try {
                MessagingStyle messagingStyle = new MessagingStyle();
                messagingStyle.restoreFromCompatExtras(extras);
                return messagingStyle;
            } catch (ClassCastException e) {
                return null;
            }
        }

        public void addCompatExtras(Bundle bundle) {
            super.addCompatExtras(bundle);
            if (this.mUserDisplayName != null) {
                bundle.putCharSequence(NotificationCompat.EXTRA_SELF_DISPLAY_NAME, this.mUserDisplayName);
            }
            if (this.mConversationTitle != null) {
                bundle.putCharSequence(NotificationCompat.EXTRA_CONVERSATION_TITLE, this.mConversationTitle);
            }
            if (!this.mMessages.isEmpty()) {
                bundle.putParcelableArray(NotificationCompat.EXTRA_MESSAGES, Message.getBundleArrayForMessages(this.mMessages));
            }
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        protected void restoreFromCompatExtras(Bundle bundle) {
            this.mMessages.clear();
            this.mUserDisplayName = bundle.getString(NotificationCompat.EXTRA_SELF_DISPLAY_NAME);
            this.mConversationTitle = bundle.getString(NotificationCompat.EXTRA_CONVERSATION_TITLE);
            Parcelable[] parcelableArray = bundle.getParcelableArray(NotificationCompat.EXTRA_MESSAGES);
            if (parcelableArray != null) {
                this.mMessages = Message.getMessagesFromBundleArray(parcelableArray);
            }
        }
    }

    interface NotificationCompatImpl {
        Notification build(Builder builder, BuilderExtender builderExtender);

        Action getAction(Notification notification, int i);

        int getActionCount(Notification notification);

        Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> arrayList);

        Bundle getBundleForUnreadConversation(UnreadConversation unreadConversation);

        String getCategory(Notification notification);

        Bundle getExtras(Notification notification);

        String getGroup(Notification notification);

        boolean getLocalOnly(Notification notification);

        ArrayList<Parcelable> getParcelableArrayListForActions(Action[] actionArr);

        String getSortKey(Notification notification);

        UnreadConversation getUnreadConversationFromBundle(Bundle bundle, UnreadConversation.Factory factory, RemoteInput.Factory factory2);

        boolean isGroupSummary(Notification notification);
    }

    static class NotificationCompatImplBase implements NotificationCompatImpl {
        NotificationCompatImplBase() {
        }

        public Notification build(Builder builder, BuilderExtender builderExtender) {
            Notification add = NotificationCompatBase.add(builder.mNotification, builder.mContext, builder.resolveTitle(), builder.resolveText(), builder.mContentIntent, builder.mFullScreenIntent);
            if (builder.mPriority > 0) {
                add.flags |= NotificationCompat.FLAG_HIGH_PRIORITY;
            }
            if (builder.mContentView != null) {
                add.contentView = builder.mContentView;
            }
            return add;
        }

        public Bundle getExtras(Notification notification) {
            return null;
        }

        public int getActionCount(Notification notification) {
            return NotificationCompat.VISIBILITY_PRIVATE;
        }

        public Action getAction(Notification notification, int i) {
            return null;
        }

        public Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> arrayList) {
            return null;
        }

        public ArrayList<Parcelable> getParcelableArrayListForActions(Action[] actionArr) {
            return null;
        }

        public String getCategory(Notification notification) {
            return null;
        }

        public boolean getLocalOnly(Notification notification) {
            return false;
        }

        public String getGroup(Notification notification) {
            return null;
        }

        public boolean isGroupSummary(Notification notification) {
            return false;
        }

        public String getSortKey(Notification notification) {
            return null;
        }

        public Bundle getBundleForUnreadConversation(UnreadConversation unreadConversation) {
            return null;
        }

        public UnreadConversation getUnreadConversationFromBundle(Bundle bundle, UnreadConversation.Factory factory, RemoteInput.Factory factory2) {
            return null;
        }
    }

    static class NotificationCompatImplJellybean extends NotificationCompatImplBase {
        NotificationCompatImplJellybean() {
        }

        public Notification build(Builder builder, BuilderExtender builderExtender) {
            NotificationBuilderWithBuilderAccessor builder2 = new android.support.v4.app.NotificationCompatJellybean.Builder(builder.mContext, builder.mNotification, builder.resolveTitle(), builder.resolveText(), builder.mContentInfo, builder.mTickerView, builder.mNumber, builder.mContentIntent, builder.mFullScreenIntent, builder.mLargeIcon, builder.mProgressMax, builder.mProgress, builder.mProgressIndeterminate, builder.mUseChronometer, builder.mPriority, builder.mSubText, builder.mLocalOnly, builder.mExtras, builder.mGroupKey, builder.mGroupSummary, builder.mSortKey, builder.mContentView, builder.mBigContentView);
            NotificationCompat.addActionsToBuilder(builder2, builder.mActions);
            NotificationCompat.addStyleToBuilderJellybean(builder2, builder.mStyle);
            Notification build = builderExtender.build(builder, builder2);
            if (builder.mStyle != null) {
                Bundle extras = getExtras(build);
                if (extras != null) {
                    builder.mStyle.addCompatExtras(extras);
                }
            }
            return build;
        }

        public Bundle getExtras(Notification notification) {
            return NotificationCompatJellybean.getExtras(notification);
        }

        public int getActionCount(Notification notification) {
            return NotificationCompatJellybean.getActionCount(notification);
        }

        public Action getAction(Notification notification, int i) {
            return (Action) NotificationCompatJellybean.getAction(notification, i, Action.FACTORY, RemoteInput.FACTORY);
        }

        public Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> arrayList) {
            return (Action[]) NotificationCompatJellybean.getActionsFromParcelableArrayList(arrayList, Action.FACTORY, RemoteInput.FACTORY);
        }

        public ArrayList<Parcelable> getParcelableArrayListForActions(Action[] actionArr) {
            return NotificationCompatJellybean.getParcelableArrayListForActions(actionArr);
        }

        public boolean getLocalOnly(Notification notification) {
            return NotificationCompatJellybean.getLocalOnly(notification);
        }

        public String getGroup(Notification notification) {
            return NotificationCompatJellybean.getGroup(notification);
        }

        public boolean isGroupSummary(Notification notification) {
            return NotificationCompatJellybean.isGroupSummary(notification);
        }

        public String getSortKey(Notification notification) {
            return NotificationCompatJellybean.getSortKey(notification);
        }
    }

    static class NotificationCompatImplKitKat extends NotificationCompatImplJellybean {
        NotificationCompatImplKitKat() {
        }

        public Notification build(Builder builder, BuilderExtender builderExtender) {
            NotificationBuilderWithBuilderAccessor builder2 = new android.support.v4.app.NotificationCompatKitKat.Builder(builder.mContext, builder.mNotification, builder.resolveTitle(), builder.resolveText(), builder.mContentInfo, builder.mTickerView, builder.mNumber, builder.mContentIntent, builder.mFullScreenIntent, builder.mLargeIcon, builder.mProgressMax, builder.mProgress, builder.mProgressIndeterminate, builder.mShowWhen, builder.mUseChronometer, builder.mPriority, builder.mSubText, builder.mLocalOnly, builder.mPeople, builder.mExtras, builder.mGroupKey, builder.mGroupSummary, builder.mSortKey, builder.mContentView, builder.mBigContentView);
            NotificationCompat.addActionsToBuilder(builder2, builder.mActions);
            NotificationCompat.addStyleToBuilderJellybean(builder2, builder.mStyle);
            return builderExtender.build(builder, builder2);
        }

        public Bundle getExtras(Notification notification) {
            return NotificationCompatKitKat.getExtras(notification);
        }

        public int getActionCount(Notification notification) {
            return NotificationCompatKitKat.getActionCount(notification);
        }

        public Action getAction(Notification notification, int i) {
            return (Action) NotificationCompatKitKat.getAction(notification, i, Action.FACTORY, RemoteInput.FACTORY);
        }

        public boolean getLocalOnly(Notification notification) {
            return NotificationCompatKitKat.getLocalOnly(notification);
        }

        public String getGroup(Notification notification) {
            return NotificationCompatKitKat.getGroup(notification);
        }

        public boolean isGroupSummary(Notification notification) {
            return NotificationCompatKitKat.isGroupSummary(notification);
        }

        public String getSortKey(Notification notification) {
            return NotificationCompatKitKat.getSortKey(notification);
        }
    }

    static class NotificationCompatImplApi20 extends NotificationCompatImplKitKat {
        NotificationCompatImplApi20() {
        }

        public Notification build(Builder builder, BuilderExtender builderExtender) {
            NotificationBuilderWithBuilderAccessor builder2 = new android.support.v4.app.NotificationCompatApi20.Builder(builder.mContext, builder.mNotification, builder.resolveTitle(), builder.resolveText(), builder.mContentInfo, builder.mTickerView, builder.mNumber, builder.mContentIntent, builder.mFullScreenIntent, builder.mLargeIcon, builder.mProgressMax, builder.mProgress, builder.mProgressIndeterminate, builder.mShowWhen, builder.mUseChronometer, builder.mPriority, builder.mSubText, builder.mLocalOnly, builder.mPeople, builder.mExtras, builder.mGroupKey, builder.mGroupSummary, builder.mSortKey, builder.mContentView, builder.mBigContentView);
            NotificationCompat.addActionsToBuilder(builder2, builder.mActions);
            NotificationCompat.addStyleToBuilderJellybean(builder2, builder.mStyle);
            Notification build = builderExtender.build(builder, builder2);
            if (builder.mStyle != null) {
                builder.mStyle.addCompatExtras(getExtras(build));
            }
            return build;
        }

        public Action getAction(Notification notification, int i) {
            return (Action) NotificationCompatApi20.getAction(notification, i, Action.FACTORY, RemoteInput.FACTORY);
        }

        public Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> arrayList) {
            return (Action[]) NotificationCompatApi20.getActionsFromParcelableArrayList(arrayList, Action.FACTORY, RemoteInput.FACTORY);
        }

        public ArrayList<Parcelable> getParcelableArrayListForActions(Action[] actionArr) {
            return NotificationCompatApi20.getParcelableArrayListForActions(actionArr);
        }

        public boolean getLocalOnly(Notification notification) {
            return NotificationCompatApi20.getLocalOnly(notification);
        }

        public String getGroup(Notification notification) {
            return NotificationCompatApi20.getGroup(notification);
        }

        public boolean isGroupSummary(Notification notification) {
            return NotificationCompatApi20.isGroupSummary(notification);
        }

        public String getSortKey(Notification notification) {
            return NotificationCompatApi20.getSortKey(notification);
        }
    }

    static class NotificationCompatImplApi21 extends NotificationCompatImplApi20 {
        NotificationCompatImplApi21() {
        }

        public Notification build(Builder builder, BuilderExtender builderExtender) {
            NotificationBuilderWithBuilderAccessor builder2 = new android.support.v4.app.NotificationCompatApi21.Builder(builder.mContext, builder.mNotification, builder.resolveTitle(), builder.resolveText(), builder.mContentInfo, builder.mTickerView, builder.mNumber, builder.mContentIntent, builder.mFullScreenIntent, builder.mLargeIcon, builder.mProgressMax, builder.mProgress, builder.mProgressIndeterminate, builder.mShowWhen, builder.mUseChronometer, builder.mPriority, builder.mSubText, builder.mLocalOnly, builder.mCategory, builder.mPeople, builder.mExtras, builder.mColor, builder.mVisibility, builder.mPublicVersion, builder.mGroupKey, builder.mGroupSummary, builder.mSortKey, builder.mContentView, builder.mBigContentView, builder.mHeadsUpContentView);
            NotificationCompat.addActionsToBuilder(builder2, builder.mActions);
            NotificationCompat.addStyleToBuilderJellybean(builder2, builder.mStyle);
            Notification build = builderExtender.build(builder, builder2);
            if (builder.mStyle != null) {
                builder.mStyle.addCompatExtras(getExtras(build));
            }
            return build;
        }

        public String getCategory(Notification notification) {
            return NotificationCompatApi21.getCategory(notification);
        }

        public Bundle getBundleForUnreadConversation(UnreadConversation unreadConversation) {
            return NotificationCompatApi21.getBundleForUnreadConversation(unreadConversation);
        }

        public UnreadConversation getUnreadConversationFromBundle(Bundle bundle, UnreadConversation.Factory factory, RemoteInput.Factory factory2) {
            return NotificationCompatApi21.getUnreadConversationFromBundle(bundle, factory, factory2);
        }
    }

    static class NotificationCompatImplApi24 extends NotificationCompatImplApi21 {
        NotificationCompatImplApi24() {
        }

        public Notification build(Builder builder, BuilderExtender builderExtender) {
            NotificationBuilderWithBuilderAccessor builder2 = new android.support.v4.app.NotificationCompatApi24.Builder(builder.mContext, builder.mNotification, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.mTickerView, builder.mNumber, builder.mContentIntent, builder.mFullScreenIntent, builder.mLargeIcon, builder.mProgressMax, builder.mProgress, builder.mProgressIndeterminate, builder.mShowWhen, builder.mUseChronometer, builder.mPriority, builder.mSubText, builder.mLocalOnly, builder.mCategory, builder.mPeople, builder.mExtras, builder.mColor, builder.mVisibility, builder.mPublicVersion, builder.mGroupKey, builder.mGroupSummary, builder.mSortKey, builder.mRemoteInputHistory, builder.mContentView, builder.mBigContentView, builder.mHeadsUpContentView);
            NotificationCompat.addActionsToBuilder(builder2, builder.mActions);
            NotificationCompat.addStyleToBuilderApi24(builder2, builder.mStyle);
            Notification build = builderExtender.build(builder, builder2);
            if (builder.mStyle != null) {
                builder.mStyle.addCompatExtras(getExtras(build));
            }
            return build;
        }
    }

    static class NotificationCompatImplHoneycomb extends NotificationCompatImplBase {
        NotificationCompatImplHoneycomb() {
        }

        public Notification build(Builder builder, BuilderExtender builderExtender) {
            Notification add = NotificationCompatHoneycomb.add(builder.mContext, builder.mNotification, builder.resolveTitle(), builder.resolveText(), builder.mContentInfo, builder.mTickerView, builder.mNumber, builder.mContentIntent, builder.mFullScreenIntent, builder.mLargeIcon);
            if (builder.mContentView != null) {
                add.contentView = builder.mContentView;
            }
            return add;
        }
    }

    static class NotificationCompatImplIceCreamSandwich extends NotificationCompatImplBase {
        NotificationCompatImplIceCreamSandwich() {
        }

        public Notification build(Builder builder, BuilderExtender builderExtender) {
            return builderExtender.build(builder, new android.support.v4.app.NotificationCompatIceCreamSandwich.Builder(builder.mContext, builder.mNotification, builder.resolveTitle(), builder.resolveText(), builder.mContentInfo, builder.mTickerView, builder.mNumber, builder.mContentIntent, builder.mFullScreenIntent, builder.mLargeIcon, builder.mProgressMax, builder.mProgress, builder.mProgressIndeterminate));
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface NotificationVisibility {
    }

    public static final class WearableExtender implements Extender {
        private static final int DEFAULT_CONTENT_ICON_GRAVITY = 8388613;
        private static final int DEFAULT_FLAGS = 1;
        private static final int DEFAULT_GRAVITY = 80;
        private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
        private static final int FLAG_BIG_PICTURE_AMBIENT = 32;
        private static final int FLAG_CONTENT_INTENT_AVAILABLE_OFFLINE = 1;
        private static final int FLAG_HINT_AVOID_BACKGROUND_CLIPPING = 16;
        private static final int FLAG_HINT_CONTENT_INTENT_LAUNCHES_ACTIVITY = 64;
        private static final int FLAG_HINT_HIDE_ICON = 2;
        private static final int FLAG_HINT_SHOW_BACKGROUND_ONLY = 4;
        private static final int FLAG_START_SCROLL_BOTTOM = 8;
        private static final String KEY_ACTIONS = "actions";
        private static final String KEY_BACKGROUND = "background";
        private static final String KEY_BRIDGE_TAG = "bridgeTag";
        private static final String KEY_CONTENT_ACTION_INDEX = "contentActionIndex";
        private static final String KEY_CONTENT_ICON = "contentIcon";
        private static final String KEY_CONTENT_ICON_GRAVITY = "contentIconGravity";
        private static final String KEY_CUSTOM_CONTENT_HEIGHT = "customContentHeight";
        private static final String KEY_CUSTOM_SIZE_PRESET = "customSizePreset";
        private static final String KEY_DISMISSAL_ID = "dismissalId";
        private static final String KEY_DISPLAY_INTENT = "displayIntent";
        private static final String KEY_FLAGS = "flags";
        private static final String KEY_GRAVITY = "gravity";
        private static final String KEY_HINT_SCREEN_TIMEOUT = "hintScreenTimeout";
        private static final String KEY_PAGES = "pages";
        public static final int SCREEN_TIMEOUT_LONG = -1;
        public static final int SCREEN_TIMEOUT_SHORT = 0;
        public static final int SIZE_DEFAULT = 0;
        public static final int SIZE_FULL_SCREEN = 5;
        public static final int SIZE_LARGE = 4;
        public static final int SIZE_MEDIUM = 3;
        public static final int SIZE_SMALL = 2;
        public static final int SIZE_XSMALL = 1;
        public static final int UNSET_ACTION_INDEX = -1;
        private ArrayList<Action> mActions;
        private Bitmap mBackground;
        private String mBridgeTag;
        private int mContentActionIndex;
        private int mContentIcon;
        private int mContentIconGravity;
        private int mCustomContentHeight;
        private int mCustomSizePreset;
        private String mDismissalId;
        private PendingIntent mDisplayIntent;
        private int mFlags;
        private int mGravity;
        private int mHintScreenTimeout;
        private ArrayList<Notification> mPages;

        public WearableExtender() {
            this.mActions = new ArrayList();
            this.mFlags = SIZE_XSMALL;
            this.mPages = new ArrayList();
            this.mContentIconGravity = DEFAULT_CONTENT_ICON_GRAVITY;
            this.mContentActionIndex = UNSET_ACTION_INDEX;
            this.mCustomSizePreset = SIZE_DEFAULT;
            this.mGravity = DEFAULT_GRAVITY;
        }

        public WearableExtender(Notification notification) {
            this.mActions = new ArrayList();
            this.mFlags = SIZE_XSMALL;
            this.mPages = new ArrayList();
            this.mContentIconGravity = DEFAULT_CONTENT_ICON_GRAVITY;
            this.mContentActionIndex = UNSET_ACTION_INDEX;
            this.mCustomSizePreset = SIZE_DEFAULT;
            this.mGravity = DEFAULT_GRAVITY;
            Bundle extras = NotificationCompat.getExtras(notification);
            Bundle bundle = extras != null ? extras.getBundle(EXTRA_WEARABLE_EXTENSIONS) : null;
            if (bundle != null) {
                Action[] actionsFromParcelableArrayList = NotificationCompat.IMPL.getActionsFromParcelableArrayList(bundle.getParcelableArrayList(KEY_ACTIONS));
                if (actionsFromParcelableArrayList != null) {
                    Collections.addAll(this.mActions, actionsFromParcelableArrayList);
                }
                this.mFlags = bundle.getInt(KEY_FLAGS, SIZE_XSMALL);
                this.mDisplayIntent = (PendingIntent) bundle.getParcelable(KEY_DISPLAY_INTENT);
                Notification[] notificationArrayFromBundle = NotificationCompat.getNotificationArrayFromBundle(bundle, KEY_PAGES);
                if (notificationArrayFromBundle != null) {
                    Collections.addAll(this.mPages, notificationArrayFromBundle);
                }
                this.mBackground = (Bitmap) bundle.getParcelable(KEY_BACKGROUND);
                this.mContentIcon = bundle.getInt(KEY_CONTENT_ICON);
                this.mContentIconGravity = bundle.getInt(KEY_CONTENT_ICON_GRAVITY, DEFAULT_CONTENT_ICON_GRAVITY);
                this.mContentActionIndex = bundle.getInt(KEY_CONTENT_ACTION_INDEX, UNSET_ACTION_INDEX);
                this.mCustomSizePreset = bundle.getInt(KEY_CUSTOM_SIZE_PRESET, SIZE_DEFAULT);
                this.mCustomContentHeight = bundle.getInt(KEY_CUSTOM_CONTENT_HEIGHT);
                this.mGravity = bundle.getInt(KEY_GRAVITY, DEFAULT_GRAVITY);
                this.mHintScreenTimeout = bundle.getInt(KEY_HINT_SCREEN_TIMEOUT);
                this.mDismissalId = bundle.getString(KEY_DISMISSAL_ID);
                this.mBridgeTag = bundle.getString(KEY_BRIDGE_TAG);
            }
        }

        public Builder extend(Builder builder) {
            Bundle bundle = new Bundle();
            if (!this.mActions.isEmpty()) {
                bundle.putParcelableArrayList(KEY_ACTIONS, NotificationCompat.IMPL.getParcelableArrayListForActions((Action[]) this.mActions.toArray(new Action[this.mActions.size()])));
            }
            if (this.mFlags != SIZE_XSMALL) {
                bundle.putInt(KEY_FLAGS, this.mFlags);
            }
            if (this.mDisplayIntent != null) {
                bundle.putParcelable(KEY_DISPLAY_INTENT, this.mDisplayIntent);
            }
            if (!this.mPages.isEmpty()) {
                bundle.putParcelableArray(KEY_PAGES, (Parcelable[]) this.mPages.toArray(new Notification[this.mPages.size()]));
            }
            if (this.mBackground != null) {
                bundle.putParcelable(KEY_BACKGROUND, this.mBackground);
            }
            if (this.mContentIcon != 0) {
                bundle.putInt(KEY_CONTENT_ICON, this.mContentIcon);
            }
            if (this.mContentIconGravity != DEFAULT_CONTENT_ICON_GRAVITY) {
                bundle.putInt(KEY_CONTENT_ICON_GRAVITY, this.mContentIconGravity);
            }
            if (this.mContentActionIndex != UNSET_ACTION_INDEX) {
                bundle.putInt(KEY_CONTENT_ACTION_INDEX, this.mContentActionIndex);
            }
            if (this.mCustomSizePreset != 0) {
                bundle.putInt(KEY_CUSTOM_SIZE_PRESET, this.mCustomSizePreset);
            }
            if (this.mCustomContentHeight != 0) {
                bundle.putInt(KEY_CUSTOM_CONTENT_HEIGHT, this.mCustomContentHeight);
            }
            if (this.mGravity != DEFAULT_GRAVITY) {
                bundle.putInt(KEY_GRAVITY, this.mGravity);
            }
            if (this.mHintScreenTimeout != 0) {
                bundle.putInt(KEY_HINT_SCREEN_TIMEOUT, this.mHintScreenTimeout);
            }
            if (this.mDismissalId != null) {
                bundle.putString(KEY_DISMISSAL_ID, this.mDismissalId);
            }
            if (this.mBridgeTag != null) {
                bundle.putString(KEY_BRIDGE_TAG, this.mBridgeTag);
            }
            builder.getExtras().putBundle(EXTRA_WEARABLE_EXTENSIONS, bundle);
            return builder;
        }

        public WearableExtender clone() {
            WearableExtender wearableExtender = new WearableExtender();
            wearableExtender.mActions = new ArrayList(this.mActions);
            wearableExtender.mFlags = this.mFlags;
            wearableExtender.mDisplayIntent = this.mDisplayIntent;
            wearableExtender.mPages = new ArrayList(this.mPages);
            wearableExtender.mBackground = this.mBackground;
            wearableExtender.mContentIcon = this.mContentIcon;
            wearableExtender.mContentIconGravity = this.mContentIconGravity;
            wearableExtender.mContentActionIndex = this.mContentActionIndex;
            wearableExtender.mCustomSizePreset = this.mCustomSizePreset;
            wearableExtender.mCustomContentHeight = this.mCustomContentHeight;
            wearableExtender.mGravity = this.mGravity;
            wearableExtender.mHintScreenTimeout = this.mHintScreenTimeout;
            wearableExtender.mDismissalId = this.mDismissalId;
            wearableExtender.mBridgeTag = this.mBridgeTag;
            return wearableExtender;
        }

        public WearableExtender addAction(Action action) {
            this.mActions.add(action);
            return this;
        }

        public WearableExtender addActions(List<Action> list) {
            this.mActions.addAll(list);
            return this;
        }

        public WearableExtender clearActions() {
            this.mActions.clear();
            return this;
        }

        public List<Action> getActions() {
            return this.mActions;
        }

        public WearableExtender setDisplayIntent(PendingIntent pendingIntent) {
            this.mDisplayIntent = pendingIntent;
            return this;
        }

        public PendingIntent getDisplayIntent() {
            return this.mDisplayIntent;
        }

        public WearableExtender addPage(Notification notification) {
            this.mPages.add(notification);
            return this;
        }

        public WearableExtender addPages(List<Notification> list) {
            this.mPages.addAll(list);
            return this;
        }

        public WearableExtender clearPages() {
            this.mPages.clear();
            return this;
        }

        public List<Notification> getPages() {
            return this.mPages;
        }

        public WearableExtender setBackground(Bitmap bitmap) {
            this.mBackground = bitmap;
            return this;
        }

        public Bitmap getBackground() {
            return this.mBackground;
        }

        public WearableExtender setContentIcon(int i) {
            this.mContentIcon = i;
            return this;
        }

        public int getContentIcon() {
            return this.mContentIcon;
        }

        public WearableExtender setContentIconGravity(int i) {
            this.mContentIconGravity = i;
            return this;
        }

        public int getContentIconGravity() {
            return this.mContentIconGravity;
        }

        public WearableExtender setContentAction(int i) {
            this.mContentActionIndex = i;
            return this;
        }

        public int getContentAction() {
            return this.mContentActionIndex;
        }

        public WearableExtender setGravity(int i) {
            this.mGravity = i;
            return this;
        }

        public int getGravity() {
            return this.mGravity;
        }

        public WearableExtender setCustomSizePreset(int i) {
            this.mCustomSizePreset = i;
            return this;
        }

        public int getCustomSizePreset() {
            return this.mCustomSizePreset;
        }

        public WearableExtender setCustomContentHeight(int i) {
            this.mCustomContentHeight = i;
            return this;
        }

        public int getCustomContentHeight() {
            return this.mCustomContentHeight;
        }

        public WearableExtender setStartScrollBottom(boolean z) {
            setFlag(FLAG_START_SCROLL_BOTTOM, z);
            return this;
        }

        public boolean getStartScrollBottom() {
            return (this.mFlags & FLAG_START_SCROLL_BOTTOM) != 0;
        }

        public WearableExtender setContentIntentAvailableOffline(boolean z) {
            setFlag(SIZE_XSMALL, z);
            return this;
        }

        public boolean getContentIntentAvailableOffline() {
            return (this.mFlags & SIZE_XSMALL) != 0;
        }

        public WearableExtender setHintHideIcon(boolean z) {
            setFlag(SIZE_SMALL, z);
            return this;
        }

        public boolean getHintHideIcon() {
            return (this.mFlags & SIZE_SMALL) != 0;
        }

        public WearableExtender setHintShowBackgroundOnly(boolean z) {
            setFlag(SIZE_LARGE, z);
            return this;
        }

        public boolean getHintShowBackgroundOnly() {
            return (this.mFlags & SIZE_LARGE) != 0;
        }

        public WearableExtender setHintAvoidBackgroundClipping(boolean z) {
            setFlag(FLAG_HINT_AVOID_BACKGROUND_CLIPPING, z);
            return this;
        }

        public boolean getHintAvoidBackgroundClipping() {
            return (this.mFlags & FLAG_HINT_AVOID_BACKGROUND_CLIPPING) != 0;
        }

        public WearableExtender setHintScreenTimeout(int i) {
            this.mHintScreenTimeout = i;
            return this;
        }

        public int getHintScreenTimeout() {
            return this.mHintScreenTimeout;
        }

        public WearableExtender setHintAmbientBigPicture(boolean z) {
            setFlag(FLAG_BIG_PICTURE_AMBIENT, z);
            return this;
        }

        public boolean getHintAmbientBigPicture() {
            return (this.mFlags & FLAG_BIG_PICTURE_AMBIENT) != 0;
        }

        public WearableExtender setHintContentIntentLaunchesActivity(boolean z) {
            setFlag(FLAG_HINT_CONTENT_INTENT_LAUNCHES_ACTIVITY, z);
            return this;
        }

        public boolean getHintContentIntentLaunchesActivity() {
            return (this.mFlags & FLAG_HINT_CONTENT_INTENT_LAUNCHES_ACTIVITY) != 0;
        }

        public WearableExtender setDismissalId(String str) {
            this.mDismissalId = str;
            return this;
        }

        public String getDismissalId() {
            return this.mDismissalId;
        }

        public WearableExtender setBridgeTag(String str) {
            this.mBridgeTag = str;
            return this;
        }

        public String getBridgeTag() {
            return this.mBridgeTag;
        }

        private void setFlag(int i, boolean z) {
            if (z) {
                this.mFlags |= i;
            } else {
                this.mFlags &= i ^ UNSET_ACTION_INDEX;
            }
        }
    }

    static void addActionsToBuilder(NotificationBuilderWithActions notificationBuilderWithActions, ArrayList<Action> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            notificationBuilderWithActions.addAction((Action) it.next());
        }
    }

    static void addStyleToBuilderJellybean(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, Style style) {
        if (style == null) {
            return;
        }
        if (style instanceof BigTextStyle) {
            BigTextStyle bigTextStyle = (BigTextStyle) style;
            NotificationCompatJellybean.addBigTextStyle(notificationBuilderWithBuilderAccessor, bigTextStyle.mBigContentTitle, bigTextStyle.mSummaryTextSet, bigTextStyle.mSummaryText, bigTextStyle.mBigText);
        } else if (style instanceof InboxStyle) {
            InboxStyle inboxStyle = (InboxStyle) style;
            NotificationCompatJellybean.addInboxStyle(notificationBuilderWithBuilderAccessor, inboxStyle.mBigContentTitle, inboxStyle.mSummaryTextSet, inboxStyle.mSummaryText, inboxStyle.mTexts);
        } else if (style instanceof BigPictureStyle) {
            BigPictureStyle bigPictureStyle = (BigPictureStyle) style;
            NotificationCompatJellybean.addBigPictureStyle(notificationBuilderWithBuilderAccessor, bigPictureStyle.mBigContentTitle, bigPictureStyle.mSummaryTextSet, bigPictureStyle.mSummaryText, bigPictureStyle.mPicture, bigPictureStyle.mBigLargeIcon, bigPictureStyle.mBigLargeIconSet);
        }
    }

    static void addStyleToBuilderApi24(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, Style style) {
        if (style == null) {
            return;
        }
        if (style instanceof MessagingStyle) {
            MessagingStyle messagingStyle = (MessagingStyle) style;
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            List arrayList3 = new ArrayList();
            List arrayList4 = new ArrayList();
            List arrayList5 = new ArrayList();
            for (Message message : messagingStyle.mMessages) {
                arrayList.add(message.getText());
                arrayList2.add(Long.valueOf(message.getTimestamp()));
                arrayList3.add(message.getSender());
                arrayList4.add(message.getDataMimeType());
                arrayList5.add(message.getDataUri());
            }
            NotificationCompatApi24.addMessagingStyle(notificationBuilderWithBuilderAccessor, messagingStyle.mUserDisplayName, messagingStyle.mConversationTitle, arrayList, arrayList2, arrayList3, arrayList4, arrayList5);
            return;
        }
        addStyleToBuilderJellybean(notificationBuilderWithBuilderAccessor, style);
    }

    static {
        if (BuildCompat.isAtLeastN()) {
            IMPL = new NotificationCompatImplApi24();
        } else if (VERSION.SDK_INT >= 21) {
            IMPL = new NotificationCompatImplApi21();
        } else if (VERSION.SDK_INT >= 20) {
            IMPL = new NotificationCompatImplApi20();
        } else if (VERSION.SDK_INT >= 19) {
            IMPL = new NotificationCompatImplKitKat();
        } else if (VERSION.SDK_INT >= FLAG_AUTO_CANCEL) {
            IMPL = new NotificationCompatImplJellybean();
        } else if (VERSION.SDK_INT >= 14) {
            IMPL = new NotificationCompatImplIceCreamSandwich();
        } else if (VERSION.SDK_INT >= 11) {
            IMPL = new NotificationCompatImplHoneycomb();
        } else {
            IMPL = new NotificationCompatImplBase();
        }
    }

    static Notification[] getNotificationArrayFromBundle(Bundle bundle, String str) {
        Parcelable[] parcelableArray = bundle.getParcelableArray(str);
        if ((parcelableArray instanceof Notification[]) || parcelableArray == null) {
            return (Notification[]) parcelableArray;
        }
        Parcelable[] parcelableArr = new Notification[parcelableArray.length];
        for (int i = VISIBILITY_PRIVATE; i < parcelableArray.length; i += VISIBILITY_PUBLIC) {
            parcelableArr[i] = (Notification) parcelableArray[i];
        }
        bundle.putParcelableArray(str, parcelableArr);
        return parcelableArr;
    }

    public static Bundle getExtras(Notification notification) {
        return IMPL.getExtras(notification);
    }

    public static int getActionCount(Notification notification) {
        return IMPL.getActionCount(notification);
    }

    public static Action getAction(Notification notification, int i) {
        return IMPL.getAction(notification, i);
    }

    public static String getCategory(Notification notification) {
        return IMPL.getCategory(notification);
    }

    public static boolean getLocalOnly(Notification notification) {
        return IMPL.getLocalOnly(notification);
    }

    public static String getGroup(Notification notification) {
        return IMPL.getGroup(notification);
    }

    public static boolean isGroupSummary(Notification notification) {
        return IMPL.isGroupSummary(notification);
    }

    public static String getSortKey(Notification notification) {
        return IMPL.getSortKey(notification);
    }
}
