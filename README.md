# DeviationTagListView
视图随列表内容加载的效果（适用于广告、活动等业务场景）

## 实现思路
思路1：根据列表滑动的偏移量控制Canvas重绘。

思路2：监听Canvas是否出现在视野中，利用BitmapRegionDecoder控制读取区域。

### Screenshots
![](https://github.com/toeii/DeviationTagListView/blob/master/screenshots.gif)
