package com.example.myapplication.retrofit;

/**
 *
 * POJO for json coming from android on call task submission
 *
 * { "call_duration_in_secs": 180, "call_rating":4.5, "call_result":"Not
 * Available", "call_notes": "Shiv kumar was not available",
 * "audio_uri":"audio.raw", "follow_up_acton":{ "type":"CALL",
 * "date_time":"2017-12-23 16:25:88", "sales_contact_person_id":"2"} }
 *
 * @author absin
 *
 */
public class TaskSubmission {
    Integer call_duration_in_secs;
    Float call_rating;
    String call_result;
    String call_notes;
    String audio_name;
    String call_sid_id;
    Integer productId;
    Boolean stage_forward;
    Float latitude;
    Float longitude;
    String taskDisposition;
    Integer taskId;
    Integer actor;
    Integer pipelineId;
    Integer stageId;

    public Integer getCall_duration_in_secs() {
        return call_duration_in_secs;
    }

    public void setCall_duration_in_secs(Integer call_duration_in_secs) {
        this.call_duration_in_secs = call_duration_in_secs;
    }

    public Float getCall_rating() {
        return call_rating;
    }

    public void setCall_rating(float call_rating) {
        this.call_rating = call_rating;
    }

    public String getCall_result() {
        return call_result;
    }

    public void setCall_result(String call_result) {
        this.call_result = call_result;
    }

    public String getCall_notes() {
        return call_notes;
    }

    public void setCall_notes(String call_notes) {
        this.call_notes = call_notes;
    }

    public String getAudio_name() {
        return audio_name;
    }

    public void setAudio_name(String audio_name) {
        this.audio_name = audio_name;
    }

    public Boolean getStage_forward() {
        return stage_forward;
    }

    public void setStage_forward(Boolean stage_forward) {
        this.stage_forward = stage_forward;
    }

    public String getCall_sid_id() {
        return call_sid_id;
    }

    public void setCall_sid_id(String call_sid_id) {
        this.call_sid_id = call_sid_id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public String getTaskDisposition() {
        return taskDisposition;
    }

    public void setTaskDisposition(String taskDisposition) {
        this.taskDisposition = taskDisposition;
    }

    public void setCall_rating(Float call_rating) {
        this.call_rating = call_rating;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getActor() {
        return actor;
    }

    public void setActor(Integer actor) {
        this.actor = actor;
    }

    public Integer getPipelineId() {
        return pipelineId;
    }

    public void setPipelineId(Integer pipelineId) {
        this.pipelineId = pipelineId;
    }

    public Integer getStageId() {
        return stageId;
    }

    public void setStageId(Integer stageId) {
        this.stageId = stageId;
    }

}