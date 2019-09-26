package com.yu.rxjava.Bean;

import java.util.List;

/**
 * CREATED BY DY ON 2019/9/19.
 * TIME BY 11:59.
 * 子分类
 **/
public class ChildBean {

    /**
     * error : false
     * results : [{"_id":"5cc43d8e9d212258d8b3f455","createdAt":"2019-04-27T11:31:26.124Z","desc":"#这个笑声够我笑一年了 ","publishedAt":"2019-04-27T11:31:48.553Z","source":"web","type":"休息视频","url":"https://v.douyin.com/6RgqG8/","used":true,"who":"lijinshanmx"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 5cc43d8e9d212258d8b3f455
         * createdAt : 2019-04-27T11:31:26.124Z
         * desc : #这个笑声够我笑一年了
         * publishedAt : 2019-04-27T11:31:48.553Z
         * source : web
         * type : 休息视频
         * url : https://v.douyin.com/6RgqG8/
         * used : true
         * who : lijinshanmx
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }
    }
}
