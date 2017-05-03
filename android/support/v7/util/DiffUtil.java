package android.support.v7.util;

import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v7.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.nend.android.NendAdIconLayout;

public class DiffUtil {
    private static final Comparator<Snake> SNAKE_COMPARATOR;

    /* renamed from: android.support.v7.util.DiffUtil.1 */
    static class C02731 implements Comparator<Snake> {
        C02731() {
        }

        public int compare(Snake snake, Snake snake2) {
            int i = snake.f349x - snake2.f349x;
            return i == 0 ? snake.f350y - snake2.f350y : i;
        }
    }

    public static abstract class Callback {
        public abstract boolean areContentsTheSame(int i, int i2);

        public abstract boolean areItemsTheSame(int i, int i2);

        public abstract int getNewListSize();

        public abstract int getOldListSize();

        @Nullable
        public Object getChangePayload(int i, int i2) {
            return null;
        }
    }

    public static class DiffResult {
        private static final int FLAG_CHANGED = 2;
        private static final int FLAG_IGNORE = 16;
        private static final int FLAG_MASK = 31;
        private static final int FLAG_MOVED_CHANGED = 4;
        private static final int FLAG_MOVED_NOT_CHANGED = 8;
        private static final int FLAG_NOT_CHANGED = 1;
        private static final int FLAG_OFFSET = 5;
        private final Callback mCallback;
        private final boolean mDetectMoves;
        private final int[] mNewItemStatuses;
        private final int mNewListSize;
        private final int[] mOldItemStatuses;
        private final int mOldListSize;
        private final List<Snake> mSnakes;

        /* renamed from: android.support.v7.util.DiffUtil.DiffResult.1 */
        class C02741 implements ListUpdateCallback {
            final /* synthetic */ Adapter val$adapter;

            C02741(Adapter adapter) {
                this.val$adapter = adapter;
            }

            public void onInserted(int i, int i2) {
                this.val$adapter.notifyItemRangeInserted(i, i2);
            }

            public void onRemoved(int i, int i2) {
                this.val$adapter.notifyItemRangeRemoved(i, i2);
            }

            public void onMoved(int i, int i2) {
                this.val$adapter.notifyItemMoved(i, i2);
            }

            public void onChanged(int i, int i2, Object obj) {
                this.val$adapter.notifyItemRangeChanged(i, i2, obj);
            }
        }

        DiffResult(Callback callback, List<Snake> list, int[] iArr, int[] iArr2, boolean z) {
            this.mSnakes = list;
            this.mOldItemStatuses = iArr;
            this.mNewItemStatuses = iArr2;
            Arrays.fill(this.mOldItemStatuses, 0);
            Arrays.fill(this.mNewItemStatuses, 0);
            this.mCallback = callback;
            this.mOldListSize = callback.getOldListSize();
            this.mNewListSize = callback.getNewListSize();
            this.mDetectMoves = z;
            addRootSnake();
            findMatchingItems();
        }

        private void addRootSnake() {
            Snake snake = this.mSnakes.isEmpty() ? null : (Snake) this.mSnakes.get(0);
            if (snake == null || snake.f349x != 0 || snake.f350y != 0) {
                snake = new Snake();
                snake.f349x = 0;
                snake.f350y = 0;
                snake.removal = false;
                snake.size = 0;
                snake.reverse = false;
                this.mSnakes.add(0, snake);
            }
        }

        private void findMatchingItems() {
            int i = this.mOldListSize;
            int i2 = this.mNewListSize;
            for (int size = this.mSnakes.size() - 1; size >= 0; size--) {
                Snake snake = (Snake) this.mSnakes.get(size);
                int i3 = snake.f349x + snake.size;
                int i4 = snake.f350y + snake.size;
                if (this.mDetectMoves) {
                    while (i > i3) {
                        findAddition(i, i2, size);
                        i--;
                    }
                    while (i2 > i4) {
                        findRemoval(i, i2, size);
                        i2--;
                    }
                }
                for (i2 = 0; i2 < snake.size; i2 += FLAG_NOT_CHANGED) {
                    i3 = snake.f349x + i2;
                    i4 = snake.f350y + i2;
                    i = this.mCallback.areContentsTheSame(i3, i4) ? FLAG_NOT_CHANGED : FLAG_CHANGED;
                    this.mOldItemStatuses[i3] = (i4 << FLAG_OFFSET) | i;
                    this.mNewItemStatuses[i4] = i | (i3 << FLAG_OFFSET);
                }
                i = snake.f349x;
                i2 = snake.f350y;
            }
        }

        private void findAddition(int i, int i2, int i3) {
            if (this.mOldItemStatuses[i - 1] == 0) {
                findMatchingItem(i, i2, i3, false);
            }
        }

        private void findRemoval(int i, int i2, int i3) {
            if (this.mNewItemStatuses[i2 - 1] == 0) {
                findMatchingItem(i, i2, i3, true);
            }
        }

        private boolean findMatchingItem(int i, int i2, int i3, boolean z) {
            int i4;
            int i5;
            int i6 = FLAG_MOVED_NOT_CHANGED;
            if (z) {
                i4 = i2 - 1;
                i2--;
                i5 = i4;
                i4 = i;
            } else {
                i5 = i - 1;
                i4 = i - 1;
            }
            int i7 = i4;
            while (i3 >= 0) {
                Snake snake = (Snake) this.mSnakes.get(i3);
                int i8 = snake.f349x + snake.size;
                int i9 = snake.f350y + snake.size;
                if (z) {
                    for (i7--; i7 >= i8; i7--) {
                        if (this.mCallback.areItemsTheSame(i7, i5)) {
                            i4 = this.mCallback.areContentsTheSame(i7, i5) ? FLAG_MOVED_NOT_CHANGED : FLAG_MOVED_CHANGED;
                            this.mNewItemStatuses[i5] = (i7 << FLAG_OFFSET) | FLAG_IGNORE;
                            this.mOldItemStatuses[i7] = i4 | (i5 << FLAG_OFFSET);
                            return true;
                        }
                    }
                    continue;
                } else {
                    for (i7 = i2 - 1; i7 >= i9; i7--) {
                        if (this.mCallback.areItemsTheSame(i5, i7)) {
                            if (!this.mCallback.areContentsTheSame(i5, i7)) {
                                i6 = FLAG_MOVED_CHANGED;
                            }
                            this.mOldItemStatuses[i - 1] = (i7 << FLAG_OFFSET) | FLAG_IGNORE;
                            this.mNewItemStatuses[i7] = ((i - 1) << FLAG_OFFSET) | i6;
                            return true;
                        }
                    }
                    continue;
                }
                i7 = snake.f349x;
                i2 = snake.f350y;
                i3--;
            }
            return false;
        }

        public void dispatchUpdatesTo(Adapter adapter) {
            dispatchUpdatesTo(new C02741(adapter));
        }

        public void dispatchUpdatesTo(ListUpdateCallback listUpdateCallback) {
            BatchingListUpdateCallback batchingListUpdateCallback;
            if (listUpdateCallback instanceof BatchingListUpdateCallback) {
                batchingListUpdateCallback = (BatchingListUpdateCallback) listUpdateCallback;
            } else {
                batchingListUpdateCallback = new BatchingListUpdateCallback(listUpdateCallback);
            }
            List arrayList = new ArrayList();
            int i = this.mOldListSize;
            int size = this.mSnakes.size() - 1;
            int i2 = this.mNewListSize;
            while (size >= 0) {
                Snake snake = (Snake) this.mSnakes.get(size);
                int i3 = snake.size;
                int i4 = snake.f349x + i3;
                int i5 = snake.f350y + i3;
                if (i4 < i) {
                    dispatchRemovals(arrayList, batchingListUpdateCallback, i4, i - i4, i4);
                }
                if (i5 < i2) {
                    dispatchAdditions(arrayList, batchingListUpdateCallback, i4, i2 - i5, i5);
                }
                for (int i6 = i3 - 1; i6 >= 0; i6--) {
                    if ((this.mOldItemStatuses[snake.f349x + i6] & FLAG_MASK) == FLAG_CHANGED) {
                        batchingListUpdateCallback.onChanged(snake.f349x + i6, FLAG_NOT_CHANGED, this.mCallback.getChangePayload(snake.f349x + i6, snake.f350y + i6));
                    }
                }
                i = snake.f349x;
                size--;
                i2 = snake.f350y;
            }
            batchingListUpdateCallback.dispatchLastEvent();
        }

        private static PostponedUpdate removePostponedUpdate(List<PostponedUpdate> list, int i, boolean z) {
            for (int size = list.size() - 1; size >= 0; size--) {
                PostponedUpdate postponedUpdate = (PostponedUpdate) list.get(size);
                if (postponedUpdate.posInOwnerList == i && postponedUpdate.removal == z) {
                    list.remove(size);
                    for (int i2 = size; i2 < list.size(); i2 += FLAG_NOT_CHANGED) {
                        PostponedUpdate postponedUpdate2 = (PostponedUpdate) list.get(i2);
                        postponedUpdate2.currentPos = (z ? FLAG_NOT_CHANGED : -1) + postponedUpdate2.currentPos;
                    }
                    return postponedUpdate;
                }
            }
            return null;
        }

        private void dispatchAdditions(List<PostponedUpdate> list, ListUpdateCallback listUpdateCallback, int i, int i2, int i3) {
            if (this.mDetectMoves) {
                for (int i4 = i2 - 1; i4 >= 0; i4--) {
                    int i5 = this.mNewItemStatuses[i3 + i4] & FLAG_MASK;
                    switch (i5) {
                        case NendAdIconLayout.HORIZONTAL /*0*/:
                            listUpdateCallback.onInserted(i, FLAG_NOT_CHANGED);
                            for (PostponedUpdate postponedUpdate : list) {
                                postponedUpdate.currentPos += FLAG_NOT_CHANGED;
                            }
                            break;
                        case FLAG_MOVED_CHANGED /*4*/:
                        case FLAG_MOVED_NOT_CHANGED /*8*/:
                            int i6 = this.mNewItemStatuses[i3 + i4] >> FLAG_OFFSET;
                            listUpdateCallback.onMoved(removePostponedUpdate(list, i6, true).currentPos, i);
                            if (i5 != FLAG_MOVED_CHANGED) {
                                break;
                            }
                            listUpdateCallback.onChanged(i, FLAG_NOT_CHANGED, this.mCallback.getChangePayload(i6, i3 + i4));
                            break;
                        case FLAG_IGNORE /*16*/:
                            list.add(new PostponedUpdate(i3 + i4, i, false));
                            break;
                        default:
                            throw new IllegalStateException("unknown flag for pos " + (i4 + i3) + " " + Long.toBinaryString((long) i5));
                    }
                }
                return;
            }
            listUpdateCallback.onInserted(i, i2);
        }

        private void dispatchRemovals(List<PostponedUpdate> list, ListUpdateCallback listUpdateCallback, int i, int i2, int i3) {
            if (this.mDetectMoves) {
                for (int i4 = i2 - 1; i4 >= 0; i4--) {
                    int i5 = this.mOldItemStatuses[i3 + i4] & FLAG_MASK;
                    switch (i5) {
                        case NendAdIconLayout.HORIZONTAL /*0*/:
                            listUpdateCallback.onRemoved(i + i4, FLAG_NOT_CHANGED);
                            for (PostponedUpdate postponedUpdate : list) {
                                postponedUpdate.currentPos--;
                            }
                            break;
                        case FLAG_MOVED_CHANGED /*4*/:
                        case FLAG_MOVED_NOT_CHANGED /*8*/:
                            int i6 = this.mOldItemStatuses[i3 + i4] >> FLAG_OFFSET;
                            PostponedUpdate removePostponedUpdate = removePostponedUpdate(list, i6, false);
                            listUpdateCallback.onMoved(i + i4, removePostponedUpdate.currentPos - 1);
                            if (i5 != FLAG_MOVED_CHANGED) {
                                break;
                            }
                            listUpdateCallback.onChanged(removePostponedUpdate.currentPos - 1, FLAG_NOT_CHANGED, this.mCallback.getChangePayload(i3 + i4, i6));
                            break;
                        case FLAG_IGNORE /*16*/:
                            list.add(new PostponedUpdate(i3 + i4, i + i4, true));
                            break;
                        default:
                            throw new IllegalStateException("unknown flag for pos " + (i4 + i3) + " " + Long.toBinaryString((long) i5));
                    }
                }
                return;
            }
            listUpdateCallback.onRemoved(i, i2);
        }

        @VisibleForTesting
        List<Snake> getSnakes() {
            return this.mSnakes;
        }
    }

    private static class PostponedUpdate {
        int currentPos;
        int posInOwnerList;
        boolean removal;

        public PostponedUpdate(int i, int i2, boolean z) {
            this.posInOwnerList = i;
            this.currentPos = i2;
            this.removal = z;
        }
    }

    static class Range {
        int newListEnd;
        int newListStart;
        int oldListEnd;
        int oldListStart;

        public Range(int i, int i2, int i3, int i4) {
            this.oldListStart = i;
            this.oldListEnd = i2;
            this.newListStart = i3;
            this.newListEnd = i4;
        }
    }

    static class Snake {
        boolean removal;
        boolean reverse;
        int size;
        int f349x;
        int f350y;

        Snake() {
        }
    }

    private DiffUtil() {
    }

    static {
        SNAKE_COMPARATOR = new C02731();
    }

    public static DiffResult calculateDiff(Callback callback) {
        return calculateDiff(callback, true);
    }

    public static DiffResult calculateDiff(Callback callback, boolean z) {
        int oldListSize = callback.getOldListSize();
        int newListSize = callback.getNewListSize();
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        arrayList2.add(new Range(0, oldListSize, 0, newListSize));
        int abs = (oldListSize + newListSize) + Math.abs(oldListSize - newListSize);
        int[] iArr = new int[(abs * 2)];
        int[] iArr2 = new int[(abs * 2)];
        List arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            Range range = (Range) arrayList2.remove(arrayList2.size() - 1);
            Snake diffPartial = diffPartial(callback, range.oldListStart, range.oldListEnd, range.newListStart, range.newListEnd, iArr, iArr2, abs);
            if (diffPartial != null) {
                if (diffPartial.size > 0) {
                    arrayList.add(diffPartial);
                }
                diffPartial.f349x += range.oldListStart;
                diffPartial.f350y += range.newListStart;
                Range range2 = arrayList3.isEmpty() ? new Range() : (Range) arrayList3.remove(arrayList3.size() - 1);
                range2.oldListStart = range.oldListStart;
                range2.newListStart = range.newListStart;
                if (diffPartial.reverse) {
                    range2.oldListEnd = diffPartial.f349x;
                    range2.newListEnd = diffPartial.f350y;
                } else if (diffPartial.removal) {
                    range2.oldListEnd = diffPartial.f349x - 1;
                    range2.newListEnd = diffPartial.f350y;
                } else {
                    range2.oldListEnd = diffPartial.f349x;
                    range2.newListEnd = diffPartial.f350y - 1;
                }
                arrayList2.add(range2);
                if (!diffPartial.reverse) {
                    range.oldListStart = diffPartial.f349x + diffPartial.size;
                    range.newListStart = diffPartial.f350y + diffPartial.size;
                } else if (diffPartial.removal) {
                    range.oldListStart = (diffPartial.f349x + diffPartial.size) + 1;
                    range.newListStart = diffPartial.f350y + diffPartial.size;
                } else {
                    range.oldListStart = diffPartial.f349x + diffPartial.size;
                    range.newListStart = (diffPartial.f350y + diffPartial.size) + 1;
                }
                arrayList2.add(range);
            } else {
                arrayList3.add(range);
            }
        }
        Collections.sort(arrayList, SNAKE_COMPARATOR);
        return new DiffResult(callback, arrayList, iArr, iArr2, z);
    }

    private static Snake diffPartial(Callback callback, int i, int i2, int i3, int i4, int[] iArr, int[] iArr2, int i5) {
        int i6 = i2 - i;
        int i7 = i4 - i3;
        if (i2 - i < 1 || i4 - i3 < 1) {
            return null;
        }
        int i8 = i6 - i7;
        int i9 = ((i6 + i7) + 1) / 2;
        Arrays.fill(iArr, (i5 - i9) - 1, (i5 + i9) + 1, 0);
        Arrays.fill(iArr2, ((i5 - i9) - 1) + i8, ((i5 + i9) + 1) + i8, i6);
        Object obj = i8 % 2 != 0 ? 1 : null;
        int i10 = 0;
        while (i10 <= i9) {
            int i11 = -i10;
            while (i11 <= i10) {
                int i12;
                boolean z;
                if (i11 == (-i10) || (i11 != i10 && iArr[(i5 + i11) - 1] < iArr[(i5 + i11) + 1])) {
                    i12 = iArr[(i5 + i11) + 1];
                    z = false;
                } else {
                    i12 = iArr[(i5 + i11) - 1] + 1;
                    z = true;
                }
                int i13 = i12;
                i12 -= i11;
                while (i13 < i6 && i12 < i7 && callback.areItemsTheSame(i + i13, i3 + i12)) {
                    i13++;
                    i12++;
                }
                iArr[i5 + i11] = i13;
                if (obj == null || i11 < (i8 - i10) + 1 || i11 > (i8 + i10) - 1 || iArr[i5 + i11] < iArr2[i5 + i11]) {
                    i11 += 2;
                } else {
                    Snake snake = new Snake();
                    snake.f349x = iArr2[i5 + i11];
                    snake.f350y = snake.f349x - i11;
                    snake.size = iArr[i5 + i11] - iArr2[i5 + i11];
                    snake.removal = z;
                    snake.reverse = false;
                    return snake;
                }
            }
            i11 = -i10;
            while (i11 <= i10) {
                int i14 = i11 + i8;
                if (i14 == i10 + i8 || (i14 != (-i10) + i8 && iArr2[(i5 + i14) - 1] < iArr2[(i5 + i14) + 1])) {
                    i12 = iArr2[(i5 + i14) - 1];
                    z = false;
                } else {
                    i12 = iArr2[(i5 + i14) + 1] - 1;
                    z = true;
                }
                i13 = i12;
                i12 -= i14;
                while (i13 > 0 && i12 > 0 && callback.areItemsTheSame((i + i13) - 1, (i3 + i12) - 1)) {
                    i13--;
                    i12--;
                }
                iArr2[i5 + i14] = i13;
                if (obj != null || i11 + i8 < (-i10) || i11 + i8 > i10 || iArr[i5 + i14] < iArr2[i5 + i14]) {
                    i11 += 2;
                } else {
                    snake = new Snake();
                    snake.f349x = iArr2[i5 + i14];
                    snake.f350y = snake.f349x - i14;
                    snake.size = iArr[i5 + i14] - iArr2[i5 + i14];
                    snake.removal = z;
                    snake.reverse = true;
                    return snake;
                }
            }
            i10++;
        }
        throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
    }
}
