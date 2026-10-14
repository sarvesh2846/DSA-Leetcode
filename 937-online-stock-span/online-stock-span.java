class StockSpanner {
    Stack<int[]> s = new Stack<>();

    public StockSpanner() {
    // constructor    
    }
    
    public int next(int price) {
        int span = 1;

        while(!s.isEmpty() && s.peek()[0] <= price){
            span += s.pop()[1];
        }
        s.push(new int[]{price, span});
        return span;
    }
}

/*
**Stock Span Problem – Tracing with Stack Diagrams**

Input: `100, 80, 60, 70, 60, 75, 85`

**Day 1: Price = 100, Span = 1**

Initially, the stack is empty. Set `span = 1`. Since the stack is empty, the while loop does not execute. Push `{100, 1}` into the stack and return `1`.

```text
       TOP
    +---------+
    | 100, 1  |
    +---------+
```

**Day 2: Price = 80, Span = 1**

Set `span = 1`. The top price is `100`. Since `100 <= 80` is false, do not pop any element. Push `{80, 1}` and return `1`.

```text
       TOP
    +---------+
    |  80, 1  |
    +---------+
    | 100, 1  |
    +---------+
```

**Day 3: Price = 60, Span = 1**

Set `span = 1`. The top price is `80`. Since `80 <= 60` is false, the while loop stops. Push `{60, 1}` and return `1`.

```text
       TOP
    +---------+
    |  60, 1  |
    +---------+
    |  80, 1  |
    +---------+
    | 100, 1  |
    +---------+
```

**Day 4: Price = 70, Span = 2**

Set `span = 1`. The top price is `60`. Since `60 <= 70` is true, pop `{60, 1}` and update `span = 1 + 1 = 2`. The new top price is `80`. Since `80 <= 70` is false, stop the loop. Push `{70, 2}` and return `2`.

```text
       TOP
    +---------+
    |  70, 2  |
    +---------+
    |  80, 1  |
    +---------+
    | 100, 1  |
    +---------+
```

**Day 5: Price = 60, Span = 1**

Set `span = 1`. The top price is `70`. Since `70 <= 60` is false, do not pop any element. Push `{60, 1}` and return `1`.

```text
       TOP
    +---------+
    |  60, 1  |
    +---------+
    |  70, 2  |
    +---------+
    |  80, 1  |
    +---------+
    | 100, 1  |
    +---------+
```

**Day 6: Price = 75, Span = 4**

Set `span = 1`. The top price is `60`. Since `60 <= 75` is true, pop `{60, 1}` and update `span = 1 + 1 = 2`. The new top price is `70`. Since `70 <= 75` is true, pop `{70, 2}` and update `span = 2 + 2 = 4`. The new top price is `80`. Since `80 <= 75` is false, stop the loop. Push `{75, 4}` and return `4`.

```text
       TOP
    +---------+
    |  75, 4  |
    +---------+
    |  80, 1  |
    +---------+
    | 100, 1  |
    +---------+
```

**Day 7: Price = 85, Span = 6**

Set `span = 1`. The top price is `75`. Since `75 <= 85` is true, pop `{75, 4}` and update `span = 1 + 4 = 5`. The new top price is `80`. Since `80 <= 85` is true, pop `{80, 1}` and update `span = 5 + 1 = 6`. The new top price is `100`. Since `100 <= 85` is false, stop the loop. Push `{85, 6}` and return `6`.

```text
       TOP
    +---------+
    |  85, 6  |
    +---------+
    | 100, 1  |
    +---------+
```

**Final Output:** `1, 1, 1, 2, 1, 4, 6`

**Key Point:** Each stack element stores `{price, span}`. When the current price is greater than or equal to the top price, pop that element and add its stored span to the current span.

*/
 




/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */