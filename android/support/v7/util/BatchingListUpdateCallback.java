package android.support.v7.util;

public class BatchingListUpdateCallback implements ListUpdateCallback {
    private static final int TYPE_ADD = 1;
    private static final int TYPE_CHANGE = 3;
    private static final int TYPE_NONE = 0;
    private static final int TYPE_REMOVE = 2;
    int mLastEventCount;
    Object mLastEventPayload;
    int mLastEventPosition;
    int mLastEventType;
    final ListUpdateCallback mWrapped;

    public BatchingListUpdateCallback(ListUpdateCallback listUpdateCallback) {
        this.mLastEventType = TYPE_NONE;
        this.mLastEventPosition = -1;
        this.mLastEventCount = -1;
        this.mLastEventPayload = null;
        this.mWrapped = listUpdateCallback;
    }

    public void dispatchLastEvent() {
        if (this.mLastEventType != 0) {
            switch (this.mLastEventType) {
                case TYPE_ADD /*1*/:
                    this.mWrapped.onInserted(this.mLastEventPosition, this.mLastEventCount);
                    break;
                case TYPE_REMOVE /*2*/:
                    this.mWrapped.onRemoved(this.mLastEventPosition, this.mLastEventCount);
                    break;
                case TYPE_CHANGE /*3*/:
                    this.mWrapped.onChanged(this.mLastEventPosition, this.mLastEventCount, this.mLastEventPayload);
                    break;
            }
            this.mLastEventPayload = null;
            this.mLastEventType = TYPE_NONE;
        }
    }

    public void onInserted(int i, int i2) {
        if (this.mLastEventType != TYPE_ADD || i < this.mLastEventPosition || i > this.mLastEventPosition + this.mLastEventCount) {
            dispatchLastEvent();
            this.mLastEventPosition = i;
            this.mLastEventCount = i2;
            this.mLastEventType = TYPE_ADD;
            return;
        }
        this.mLastEventCount += i2;
        this.mLastEventPosition = Math.min(i, this.mLastEventPosition);
    }

    public void onRemoved(int i, int i2) {
        if (this.mLastEventType != TYPE_REMOVE || this.mLastEventPosition < i || this.mLastEventPosition > i + i2) {
            dispatchLastEvent();
            this.mLastEventPosition = i;
            this.mLastEventCount = i2;
            this.mLastEventType = TYPE_REMOVE;
            return;
        }
        this.mLastEventCount += i2;
        this.mLastEventPosition = i;
    }

    public void onMoved(int i, int i2) {
        dispatchLastEvent();
        this.mWrapped.onMoved(i, i2);
    }

    public void onChanged(int i, int i2, Object obj) {
        if (this.mLastEventType != TYPE_CHANGE || i > this.mLastEventPosition + this.mLastEventCount || i + i2 < this.mLastEventPosition || this.mLastEventPayload != obj) {
            dispatchLastEvent();
            this.mLastEventPosition = i;
            this.mLastEventCount = i2;
            this.mLastEventPayload = obj;
            this.mLastEventType = TYPE_CHANGE;
            return;
        }
        int i3 = this.mLastEventPosition + this.mLastEventCount;
        this.mLastEventPosition = Math.min(i, this.mLastEventPosition);
        this.mLastEventCount = Math.max(i3, i + i2) - this.mLastEventPosition;
    }
}
