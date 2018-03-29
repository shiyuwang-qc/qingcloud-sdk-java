// +-------------------------------------------------------------------------
// | Copyright (C) 2016 Yunify, Inc.
// +-------------------------------------------------------------------------
// | Licensed under the Apache License, Version 2.0 (the "License");
// | you may not use this work except in compliance with the License.
// | You may obtain a copy of the License in the LICENSE file, or at:
// |
// | http://www.apache.org/licenses/LICENSE-2.0
// |
// | Unless required by applicable law or agreed to in writing, software
// | distributed under the License is distributed on an "AS IS" BASIS,
// | WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// | See the License for the specific language governing permissions and
// | limitations under the License.
// +-------------------------------------------------------------------------

package com.qingcloud.sdk.service;

import com.qingcloud.sdk.config.EnvContext;
import com.qingcloud.sdk.constants.QCConstant;
import com.qingcloud.sdk.model.OutputModel;
import com.qingcloud.sdk.request.ResponseCallBack;
import com.qingcloud.sdk.request.ResourceRequestFactory;
import com.qingcloud.sdk.exception.QCException;
import com.qingcloud.sdk.model.IaasParamBody;
import com.qingcloud.sdk.service.Types.*;
import com.qingcloud.sdk.annotation.ParamAnnotation;
import com.qingcloud.sdk.utils.QCStringUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MongoService {

    private EnvContext envContext;

    private String zone;

    public MongoService(EnvContext envContext) {
        this.envContext = envContext;
    }

    public MongoService(EnvContext envContext, String zone) {
        this.envContext = envContext;
        this.zone = zone;
    }
        
    /**
      * @param input
      * @throws QCException
      *
      * Documentation URL: https://docs.qingcloud.com/api/mongo/add_mongo_instances.html
      */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public AddMongoInstancesOutput addMongoInstances(AddMongoInstancesInput input) throws QCException {
        if (input == null) {
            input = new AddMongoInstancesInput();
        }
        Map context = new HashMap();
        context.put(QCConstant.ENV_CONTEXT_KEY, this.envContext);
        context.put("OperationName", "AddMongoInstances");
        context.put("APIName", "AddMongoInstances");
        context.put("ServiceName", "AddMongoInstances");
        context.put("RequestMethod", "GET");
        context.put("RequestURI", "/AddMongoInstances");

        input.setAction("AddMongoInstances");
        if (QCStringUtil.isEmpty(this.zone)) {
            input.setZone(this.envContext.getZone());
        } else {
            input.setZone(this.zone);
        }

        Object backModel = ResourceRequestFactory.getResourceRequest().sendApiRequest(context, input,AddMongoInstancesOutput.class);
        if(backModel != null){
            return (AddMongoInstancesOutput)backModel;
        }
        return null;
    }

     /**
       * @param input
       * @param callback
       * @throws QCException
       *
       * Documentation URL: https://docs.qingcloud.com/api/mongo/add_mongo_instances.html
       */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void addMongoInstances(AddMongoInstancesInput input, ResponseCallBack<AddMongoInstancesOutput> callback) throws QCException {
        if (input == null) {
            input = new AddMongoInstancesInput();
        }
        Map context = new HashMap();
        context.put(QCConstant.ENV_CONTEXT_KEY, this.envContext);
        context.put("OperationName", "AddMongoInstances");
        context.put("APIName", "AddMongoInstances");
        context.put("ServiceName", "AddMongoInstances");
        context.put("RequestMethod", "GET");
        context.put("RequestURI", "/AddMongoInstances");

        input.setAction("AddMongoInstances");
        if (QCStringUtil.isEmpty(this.zone)) {
            input.setZone(this.envContext.getZone());
        } else {
            input.setZone(this.zone);
        }

        if(callback == null) {
            throw new QCException("callback can't be null");
        }

        ResourceRequestFactory.getResourceRequest().sendApiRequestAsync(context,input,callback);
    }

    public static class AddMongoInstancesInput extends IaasParamBody {
        private String mongo;

        @ParamAnnotation(paramType = "query", paramName = "mongo")
        public void setMongo(String mongo) {
            this.mongo = mongo;
        }

        @ParamAnnotation(paramType = "query", paramName = "mongo")
        public String getMongo() {
            return this.mongo;
        }

        private Integer nodeCount;

        @ParamAnnotation(paramType = "query", paramName = "node_count")
        public void setNodeCount(Integer nodeCount) {
            this.nodeCount = nodeCount;
        }

        @ParamAnnotation(paramType = "query", paramName = "node_count")
        public Integer getNodeCount() {
            return this.nodeCount;
        }

        private List<MongoPrivateIPModel> privateIPs;

        @ParamAnnotation(paramType = "query", paramName = "private_ips")
        public void setPrivateIPs(List<MongoPrivateIPModel> privateIPs) {
            this.privateIPs = privateIPs;
        }

        @ParamAnnotation(paramType = "query", paramName = "private_ips")
        public List<MongoPrivateIPModel> getPrivateIPs() {
            return this.privateIPs;
        }

        public String validateParam() throws QCException {
            if (this.getPrivateIPs() != null && this.getPrivateIPs().size() > 0 ) {
                for (int i = 0 ; i < this.getPrivateIPs().size(); i++ ) {
                    
                    return null;

                    //if (!QCStringUtil.isEmpty(vValidate)) {
                    //    return vValidate;
                    // }
                }
            }
            return null;
        }
    }

    public static class AddMongoInstancesOutput extends OutputModel {
        private String action;

        @ParamAnnotation(paramType = "query", paramName = "action")
        public void setAction(String action) {
            this.action = action;
        }

        @ParamAnnotation(paramType = "query", paramName = "action")
        public String getAction() {
            return this.action;
        }

        private String jobID;

        @ParamAnnotation(paramType = "query", paramName = "job_id")
        public void setJobID(String jobID) {
            this.jobID = jobID;
        }

        @ParamAnnotation(paramType = "query", paramName = "job_id")
        public String getJobID() {
            return this.jobID;
        }

        private String mongo;

        @ParamAnnotation(paramType = "query", paramName = "mongo")
        public void setMongo(String mongo) {
            this.mongo = mongo;
        }

        @ParamAnnotation(paramType = "query", paramName = "mongo")
        public String getMongo() {
            return this.mongo;
        }

        private List<String> mongoNode;

        @ParamAnnotation(paramType = "query", paramName = "mongo_node")
        public void setMongoNode(List<String> mongoNode) {
            this.mongoNode = mongoNode;
        }

        @ParamAnnotation(paramType = "query", paramName = "mongo_node")
        public List<String> getMongoNode() {
            return this.mongoNode;
        }

        private Integer retCode;

        @ParamAnnotation(paramType = "query", paramName = "ret_code")
        public void setRetCode(Integer retCode) {
            this.retCode = retCode;
        }

        @ParamAnnotation(paramType = "query", paramName = "ret_code")
        public Integer getRetCode() {
            return this.retCode;
        }

    }
        
    /**
      * @param input
      * @throws QCException
      *
      * Documentation URL: https://docs.qingcloud.com/api/mongo/change_mongo_vxnet.html
      */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public ChangeMongoVxNetOutput changeMongoVxNet(ChangeMongoVxNetInput input) throws QCException {
        if (input == null) {
            input = new ChangeMongoVxNetInput();
        }
        Map context = new HashMap();
        context.put(QCConstant.ENV_CONTEXT_KEY, this.envContext);
        context.put("OperationName", "ChangeMongoVxnet");
        context.put("APIName", "ChangeMongoVxnet");
        context.put("ServiceName", "ChangeMongoVxnet");
        context.put("RequestMethod", "GET");
        context.put("RequestURI", "/ChangeMongoVxnet");

        input.setAction("ChangeMongoVxnet");
        if (QCStringUtil.isEmpty(this.zone)) {
            input.setZone(this.envContext.getZone());
        } else {
            input.setZone(this.zone);
        }

        Object backModel = ResourceRequestFactory.getResourceRequest().sendApiRequest(context, input,ChangeMongoVxNetOutput.class);
        if(backModel != null){
            return (ChangeMongoVxNetOutput)backModel;
        }
        return null;
    }

     /**
       * @param input
       * @param callback
       * @throws QCException
       *
       * Documentation URL: https://docs.qingcloud.com/api/mongo/change_mongo_vxnet.html
       */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void changeMongoVxNet(ChangeMongoVxNetInput input, ResponseCallBack<ChangeMongoVxNetOutput> callback) throws QCException {
        if (input == null) {
            input = new ChangeMongoVxNetInput();
        }
        Map context = new HashMap();
        context.put(QCConstant.ENV_CONTEXT_KEY, this.envContext);
        context.put("OperationName", "ChangeMongoVxNet");
        context.put("APIName", "ChangeMongoVxNet");
        context.put("ServiceName", "ChangeMongoVxnet");
        context.put("RequestMethod", "GET");
        context.put("RequestURI", "/ChangeMongoVxnet");

        input.setAction("ChangeMongoVxNet");
        if (QCStringUtil.isEmpty(this.zone)) {
            input.setZone(this.envContext.getZone());
        } else {
            input.setZone(this.zone);
        }

        if(callback == null) {
            throw new QCException("callback can't be null");
        }

        ResourceRequestFactory.getResourceRequest().sendApiRequestAsync(context,input,callback);
    }

    public static class ChangeMongoVxNetInput extends IaasParamBody {
        // Required
        private String mongo;

        @ParamAnnotation(paramType = "query", paramName = "mongo")
        public void setMongo(String mongo) {
            this.mongo = mongo;
        }

        @ParamAnnotation(paramType = "query", paramName = "mongo")
        public String getMongo() {
            return this.mongo;
        }

        private List<MongoPrivateIPModel> privateIPs;

        @ParamAnnotation(paramType = "query", paramName = "private_ips")
        public void setPrivateIPs(List<MongoPrivateIPModel> privateIPs) {
            this.privateIPs = privateIPs;
        }

        @ParamAnnotation(paramType = "query", paramName = "private_ips")
        public List<MongoPrivateIPModel> getPrivateIPs() {
            return this.privateIPs;
        }

        // Required
        private String vxNet;

        @ParamAnnotation(paramType = "query", paramName = "vxnet")
        public void setVxNet(String vxNet) {
            this.vxNet = vxNet;
        }

        @ParamAnnotation(paramType = "query", paramName = "vxnet")
        public String getVxNet() {
            return this.vxNet;
        }

        public String validateParam() throws QCException {
            if (QCStringUtil.isEmpty(this.getMongo())) {
                throw new QCException("Mongo is required");
            }
            if (this.getPrivateIPs() != null && this.getPrivateIPs().size() > 0 ) {
                for (int i = 0 ; i < this.getPrivateIPs().size(); i++ ) {
                    
                    return null;

                    //if (!QCStringUtil.isEmpty(vValidate)) {
                    //    return vValidate;
                    // }
                }
            }
            if (QCStringUtil.isEmpty(this.getVxNet())) {
                throw new QCException("VxNet is required");
            }
            return null;
        }
    }

    public static class ChangeMongoVxNetOutput extends OutputModel {
        private String action;

        @ParamAnnotation(paramType = "query", paramName = "action")
        public void setAction(String action) {
            this.action = action;
        }

        @ParamAnnotation(paramType = "query", paramName = "action")
        public String getAction() {
            return this.action;
        }

        private String jobID;

        @ParamAnnotation(paramType = "query", paramName = "job_id")
        public void setJobID(String jobID) {
            this.jobID = jobID;
        }

        @ParamAnnotation(paramType = "query", paramName = "job_id")
        public String getJobID() {
            return this.jobID;
        }

        private String mongo;

        @ParamAnnotation(paramType = "query", paramName = "mongo")
        public void setMongo(String mongo) {
            this.mongo = mongo;
        }

        @ParamAnnotation(paramType = "query", paramName = "mongo")
        public String getMongo() {
            return this.mongo;
        }

        private Integer retCode;

        @ParamAnnotation(paramType = "query", paramName = "ret_code")
        public void setRetCode(Integer retCode) {
            this.retCode = retCode;
        }

        @ParamAnnotation(paramType = "query", paramName = "ret_code")
        public Integer getRetCode() {
            return this.retCode;
        }

    }
        
    /**
      * @param input
      * @throws QCException
      *
      * Documentation URL: https://docs.qingcloud.com/api/mongo/create_mongo.html
      */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public CreateMongoOutput createMongo(CreateMongoInput input) throws QCException {
        if (input == null) {
            input = new CreateMongoInput();
        }
        Map context = new HashMap();
        context.put(QCConstant.ENV_CONTEXT_KEY, this.envContext);
        context.put("OperationName", "CreateMongo");
        context.put("APIName", "CreateMongo");
        context.put("ServiceName", "CreateMongo");
        context.put("RequestMethod", "GET");
        context.put("RequestURI", "/CreateMongo");

        input.setAction("CreateMongo");
        if (QCStringUtil.isEmpty(this.zone)) {
            input.setZone(this.envContext.getZone());
        } else {
            input.setZone(this.zone);
        }

        Object backModel = ResourceRequestFactory.getResourceRequest().sendApiRequest(context, input,CreateMongoOutput.class);
        if(backModel != null){
            return (CreateMongoOutput)backModel;
        }
        return null;
    }

     /**
       * @param input
       * @param callback
       * @throws QCException
       *
       * Documentation URL: https://docs.qingcloud.com/api/mongo/create_mongo.html
       */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void createMongo(CreateMongoInput input, ResponseCallBack<CreateMongoOutput> callback) throws QCException {
        if (input == null) {
            input = new CreateMongoInput();
        }
        Map context = new HashMap();
        context.put(QCConstant.ENV_CONTEXT_KEY, this.envContext);
        context.put("OperationName", "CreateMongo");
        context.put("APIName", "CreateMongo");
        context.put("ServiceName", "CreateMongo");
        context.put("RequestMethod", "GET");
        context.put("RequestURI", "/CreateMongo");

        input.setAction("CreateMongo");
        if (QCStringUtil.isEmpty(this.zone)) {
            input.setZone(this.envContext.getZone());
        } else {
            input.setZone(this.zone);
        }

        if(callback == null) {
            throw new QCException("callback can't be null");
        }

        ResourceRequestFactory.getResourceRequest().sendApiRequestAsync(context,input,callback);
    }

    public static class CreateMongoInput extends IaasParamBody {
        private Integer autoBackupTime;

        @ParamAnnotation(paramType = "query", paramName = "auto_backup_time")
        public void setAutoBackupTime(Integer autoBackupTime) {
            this.autoBackupTime = autoBackupTime;
        }

        @ParamAnnotation(paramType = "query", paramName = "auto_backup_time")
        public Integer getAutoBackupTime() {
            return this.autoBackupTime;
        }

        private String description;

        @ParamAnnotation(paramType = "query", paramName = "description")
        public void setDescription(String description) {
            this.description = description;
        }

        @ParamAnnotation(paramType = "query", paramName = "description")
        public String getDescription() {
            return this.description;
        }

        private String mongoName;

        @ParamAnnotation(paramType = "query", paramName = "mongo_name")
        public void setMongoName(String mongoName) {
            this.mongoName = mongoName;
        }

        @ParamAnnotation(paramType = "query", paramName = "mongo_name")
        public String getMongoName() {
            return this.mongoName;
        }

        private String mongoPassword;

        @ParamAnnotation(paramType = "query", paramName = "mongo_password")
        public void setMongoPassword(String mongoPassword) {
            this.mongoPassword = mongoPassword;
        }

        @ParamAnnotation(paramType = "query", paramName = "mongo_password")
        public String getMongoPassword() {
            return this.mongoPassword;
        }

        // Required
        private Integer mongoType;

        @ParamAnnotation(paramType = "query", paramName = "mongo_type")
        public void setMongoType(Integer mongoType) {
            this.mongoType = mongoType;
        }

        @ParamAnnotation(paramType = "query", paramName = "mongo_type")
        public Integer getMongoType() {
            return this.mongoType;
        }

        private String mongoUsername;

        @ParamAnnotation(paramType = "query", paramName = "mongo_username")
        public void setMongoUsername(String mongoUsername) {
            this.mongoUsername = mongoUsername;
        }

        @ParamAnnotation(paramType = "query", paramName = "mongo_username")
        public String getMongoUsername() {
            return this.mongoUsername;
        }

        private String mongoVersion;

        @ParamAnnotation(paramType = "query", paramName = "mongo_version")
        public void setMongoVersion(String mongoVersion) {
            this.mongoVersion = mongoVersion;
        }

        @ParamAnnotation(paramType = "query", paramName = "mongo_version")
        public String getMongoVersion() {
            return this.mongoVersion;
        }

        private List<MongoPrivateIPModel> privateIPs;

        @ParamAnnotation(paramType = "query", paramName = "private_ips")
        public void setPrivateIPs(List<MongoPrivateIPModel> privateIPs) {
            this.privateIPs = privateIPs;
        }

        @ParamAnnotation(paramType = "query", paramName = "private_ips")
        public List<MongoPrivateIPModel> getPrivateIPs() {
            return this.privateIPs;
        }

        private Integer resourceClass;

        @ParamAnnotation(paramType = "query", paramName = "resource_class")
        public void setResourceClass(Integer resourceClass) {
            this.resourceClass = resourceClass;
        }

        @ParamAnnotation(paramType = "query", paramName = "resource_class")
        public Integer getResourceClass() {
            return this.resourceClass;
        }

        // Required
        private Integer storageSize;

        @ParamAnnotation(paramType = "query", paramName = "storage_size")
        public void setStorageSize(Integer storageSize) {
            this.storageSize = storageSize;
        }

        @ParamAnnotation(paramType = "query", paramName = "storage_size")
        public Integer getStorageSize() {
            return this.storageSize;
        }

        // Required
        private String vxNet;

        @ParamAnnotation(paramType = "query", paramName = "vxnet")
        public void setVxNet(String vxNet) {
            this.vxNet = vxNet;
        }

        @ParamAnnotation(paramType = "query", paramName = "vxnet")
        public String getVxNet() {
            return this.vxNet;
        }

        public String validateParam() throws QCException {
            if (this.getMongoType() < 0 ) {
                throw new QCException("MongoType is required");
            }
            if (this.getPrivateIPs() != null && this.getPrivateIPs().size() > 0 ) {
                for (int i = 0 ; i < this.getPrivateIPs().size(); i++ ) {
                    
                    return null;

                    //if (!QCStringUtil.isEmpty(vValidate)) {
                    //    return vValidate;
                    // }
                }
            }
            if (this.getStorageSize() < 0 ) {
                throw new QCException("StorageSize is required");
            }
            if (QCStringUtil.isEmpty(this.getVxNet())) {
                throw new QCException("VxNet is required");
            }
            return null;
        }
    }

    public static class CreateMongoOutput extends OutputModel {
        private String action;

        @ParamAnnotation(paramType = "query", paramName = "action")
        public void setAction(String action) {
            this.action = action;
        }

        @ParamAnnotation(paramType = "query", paramName = "action")
        public String getAction() {
            return this.action;
        }

        private String jobID;

        @ParamAnnotation(paramType = "query", paramName = "job_id")
        public void setJobID(String jobID) {
            this.jobID = jobID;
        }

        @ParamAnnotation(paramType = "query", paramName = "job_id")
        public String getJobID() {
            return this.jobID;
        }

        private String mongo;

        @ParamAnnotation(paramType = "query", paramName = "mongo")
        public void setMongo(String mongo) {
            this.mongo = mongo;
        }

        @ParamAnnotation(paramType = "query", paramName = "mongo")
        public String getMongo() {
            return this.mongo;
        }

        private Integer retCode;

        @ParamAnnotation(paramType = "query", paramName = "ret_code")
        public void setRetCode(Integer retCode) {
            this.retCode = retCode;
        }

        @ParamAnnotation(paramType = "query", paramName = "ret_code")
        public Integer getRetCode() {
            return this.retCode;
        }

    }
        
    /**
      * @param input
      * @throws QCException
      *
      * Documentation URL: https://docs.qingcloud.com/api/mongo/create_mongo_from_snapshot.html
      */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public CreateMongoFromSnapshotOutput createMongoFromSnapshot(CreateMongoFromSnapshotInput input) throws QCException {
        if (input == null) {
            input = new CreateMongoFromSnapshotInput();
        }
        Map context = new HashMap();
        context.put(QCConstant.ENV_CONTEXT_KEY, this.envContext);
        context.put("OperationName", "CreateMongoFromSnapshot");
        context.put("APIName", "CreateMongoFromSnapshot");
        context.put("ServiceName", "CreateMongoFromSnapshot");
        context.put("RequestMethod", "GET");
        context.put("RequestURI", "/CreateMongoFromSnapshot");

        input.setAction("CreateMongoFromSnapshot");
        if (QCStringUtil.isEmpty(this.zone)) {
            input.setZone(this.envContext.getZone());
        } else {
            input.setZone(this.zone);
        }

        Object backModel = ResourceRequestFactory.getResourceRequest().sendApiRequest(context, input,CreateMongoFromSnapshotOutput.class);
        if(backModel != null){
            return (CreateMongoFromSnapshotOutput)backModel;
        }
        return null;
    }

     /**
       * @param input
       * @param callback
       * @throws QCException
       *
       * Documentation URL: https://docs.qingcloud.com/api/mongo/create_mongo_from_snapshot.html
       */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void createMongoFromSnapshot(CreateMongoFromSnapshotInput input, ResponseCallBack<CreateMongoFromSnapshotOutput> callback) throws QCException {
        if (input == null) {
            input = new CreateMongoFromSnapshotInput();
        }
        Map context = new HashMap();
        context.put(QCConstant.ENV_CONTEXT_KEY, this.envContext);
        context.put("OperationName", "CreateMongoFromSnapshot");
        context.put("APIName", "CreateMongoFromSnapshot");
        context.put("ServiceName", "CreateMongoFromSnapshot");
        context.put("RequestMethod", "GET");
        context.put("RequestURI", "/CreateMongoFromSnapshot");

        input.setAction("CreateMongoFromSnapshot");
        if (QCStringUtil.isEmpty(this.zone)) {
            input.setZone(this.envContext.getZone());
        } else {
            input.setZone(this.zone);
        }

        if(callback == null) {
            throw new QCException("callback can't be null");
        }

        ResourceRequestFactory.getResourceRequest().sendApiRequestAsync(context,input,callback);
    }

    public static class CreateMongoFromSnapshotInput extends IaasParamBody {
        private Integer autoBackupTime;

        @ParamAnnotation(paramType = "query", paramName = "auto_backup_time")
        public void setAutoBackupTime(Integer autoBackupTime) {
            this.autoBackupTime = autoBackupTime;
        }

        @ParamAnnotation(paramType = "query", paramName = "auto_backup_time")
        public Integer getAutoBackupTime() {
            return this.autoBackupTime;
        }

        private String mongoName;

        @ParamAnnotation(paramType = "query", paramName = "mongo_name")
        public void setMongoName(String mongoName) {
            this.mongoName = mongoName;
        }

        @ParamAnnotation(paramType = "query", paramName = "mongo_name")
        public String getMongoName() {
            return this.mongoName;
        }

        private Integer mongoType;

        @ParamAnnotation(paramType = "query", paramName = "mongo_type")
        public void setMongoType(Integer mongoType) {
            this.mongoType = mongoType;
        }

        @ParamAnnotation(paramType = "query", paramName = "mongo_type")
        public Integer getMongoType() {
            return this.mongoType;
        }

        private Integer mongoVersion;

        @ParamAnnotation(paramType = "query", paramName = "mongo_version")
        public void setMongoVersion(Integer mongoVersion) {
            this.mongoVersion = mongoVersion;
        }

        @ParamAnnotation(paramType = "query", paramName = "mongo_version")
        public Integer getMongoVersion() {
            return this.mongoVersion;
        }

        private Integer resourceClass;

        @ParamAnnotation(paramType = "query", paramName = "resource_class")
        public void setResourceClass(Integer resourceClass) {
            this.resourceClass = resourceClass;
        }

        @ParamAnnotation(paramType = "query", paramName = "resource_class")
        public Integer getResourceClass() {
            return this.resourceClass;
        }

        private String snapshot;

        @ParamAnnotation(paramType = "query", paramName = "snapshot")
        public void setSnapshot(String snapshot) {
            this.snapshot = snapshot;
        }

        @ParamAnnotation(paramType = "query", paramName = "snapshot")
        public String getSnapshot() {
            return this.snapshot;
        }

        private Integer storageSize;

        @ParamAnnotation(paramType = "query", paramName = "storage_size")
        public void setStorageSize(Integer storageSize) {
            this.storageSize = storageSize;
        }

        @ParamAnnotation(paramType = "query", paramName = "storage_size")
        public Integer getStorageSize() {
            return this.storageSize;
        }

        private String vxNet;

        @ParamAnnotation(paramType = "query", paramName = "vxnet")
        public void setVxNet(String vxNet) {
            this.vxNet = vxNet;
        }

        @ParamAnnotation(paramType = "query", paramName = "vxnet")
        public String getVxNet() {
            return this.vxNet;
        }

        public String validateParam() throws QCException {
            return null;
        }
    }

    public static class CreateMongoFromSnapshotOutput extends OutputModel {
        private String action;

        @ParamAnnotation(paramType = "query", paramName = "action")
        public void setAction(String action) {
            this.action = action;
        }

        @ParamAnnotation(paramType = "query", paramName = "action")
        public String getAction() {
            return this.action;
        }

        private String jobID;

        @ParamAnnotation(paramType = "query", paramName = "job_id")
        public void setJobID(String jobID) {
            this.jobID = jobID;
        }

        @ParamAnnotation(paramType = "query", paramName = "job_id")
        public String getJobID() {
            return this.jobID;
        }

        private String mongo;

        @ParamAnnotation(paramType = "query", paramName = "mongo")
        public void setMongo(String mongo) {
            this.mongo = mongo;
        }

        @ParamAnnotation(paramType = "query", paramName = "mongo")
        public String getMongo() {
            return this.mongo;
        }

        private Integer retCode;

        @ParamAnnotation(paramType = "query", paramName = "ret_code")
        public void setRetCode(Integer retCode) {
            this.retCode = retCode;
        }

        @ParamAnnotation(paramType = "query", paramName = "ret_code")
        public Integer getRetCode() {
            return this.retCode;
        }

    }
        
    /**
      * @param input
      * @throws QCException
      *
      * Documentation URL: https://docs.qingcloud.com/api/mongo/delete_mongos.html
      */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public DeleteMongosOutput deleteMongos(DeleteMongosInput input) throws QCException {
        if (input == null) {
            input = new DeleteMongosInput();
        }
        Map context = new HashMap();
        context.put(QCConstant.ENV_CONTEXT_KEY, this.envContext);
        context.put("OperationName", "DeleteMongos");
        context.put("APIName", "DeleteMongos");
        context.put("ServiceName", "DeleteMongos");
        context.put("RequestMethod", "GET");
        context.put("RequestURI", "/DeleteMongos");

        input.setAction("DeleteMongos");
        if (QCStringUtil.isEmpty(this.zone)) {
            input.setZone(this.envContext.getZone());
        } else {
            input.setZone(this.zone);
        }

        Object backModel = ResourceRequestFactory.getResourceRequest().sendApiRequest(context, input,DeleteMongosOutput.class);
        if(backModel != null){
            return (DeleteMongosOutput)backModel;
        }
        return null;
    }

     /**
       * @param input
       * @param callback
       * @throws QCException
       *
       * Documentation URL: https://docs.qingcloud.com/api/mongo/delete_mongos.html
       */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void deleteMongos(DeleteMongosInput input, ResponseCallBack<DeleteMongosOutput> callback) throws QCException {
        if (input == null) {
            input = new DeleteMongosInput();
        }
        Map context = new HashMap();
        context.put(QCConstant.ENV_CONTEXT_KEY, this.envContext);
        context.put("OperationName", "DeleteMongos");
        context.put("APIName", "DeleteMongos");
        context.put("ServiceName", "DeleteMongos");
        context.put("RequestMethod", "GET");
        context.put("RequestURI", "/DeleteMongos");

        input.setAction("DeleteMongos");
        if (QCStringUtil.isEmpty(this.zone)) {
            input.setZone(this.envContext.getZone());
        } else {
            input.setZone(this.zone);
        }

        if(callback == null) {
            throw new QCException("callback can't be null");
        }

        ResourceRequestFactory.getResourceRequest().sendApiRequestAsync(context,input,callback);
    }

    public static class DeleteMongosInput extends IaasParamBody {
        // Required
        private List<String> mongos;

        @ParamAnnotation(paramType = "query", paramName = "mongos")
        public void setMongos(List<String> mongos) {
            this.mongos = mongos;
        }

        @ParamAnnotation(paramType = "query", paramName = "mongos")
        public List<String> getMongos() {
            return this.mongos;
        }

        public String validateParam() throws QCException {
            return null;
        }
    }

    public static class DeleteMongosOutput extends OutputModel {
        private String action;

        @ParamAnnotation(paramType = "query", paramName = "action")
        public void setAction(String action) {
            this.action = action;
        }

        @ParamAnnotation(paramType = "query", paramName = "action")
        public String getAction() {
            return this.action;
        }

        private String jobID;

        @ParamAnnotation(paramType = "query", paramName = "job_id")
        public void setJobID(String jobID) {
            this.jobID = jobID;
        }

        @ParamAnnotation(paramType = "query", paramName = "job_id")
        public String getJobID() {
            return this.jobID;
        }

        private List<String> mongos;

        @ParamAnnotation(paramType = "query", paramName = "mongos")
        public void setMongos(List<String> mongos) {
            this.mongos = mongos;
        }

        @ParamAnnotation(paramType = "query", paramName = "mongos")
        public List<String> getMongos() {
            return this.mongos;
        }

        private Integer retCode;

        @ParamAnnotation(paramType = "query", paramName = "ret_code")
        public void setRetCode(Integer retCode) {
            this.retCode = retCode;
        }

        @ParamAnnotation(paramType = "query", paramName = "ret_code")
        public Integer getRetCode() {
            return this.retCode;
        }

    }
        
    /**
      * @param input
      * @throws QCException
      *
      * Documentation URL: https://docs.qingcloud.com/api/mongo/describe_mongo_nodes.html
      */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public DescribeMongoNodesOutput describeMongoNodes(DescribeMongoNodesInput input) throws QCException {
        if (input == null) {
            input = new DescribeMongoNodesInput();
        }
        Map context = new HashMap();
        context.put(QCConstant.ENV_CONTEXT_KEY, this.envContext);
        context.put("OperationName", "DescribeMongoNodes");
        context.put("APIName", "DescribeMongoNodes");
        context.put("ServiceName", "DescribeMongoNodes");
        context.put("RequestMethod", "GET");
        context.put("RequestURI", "/DescribeMongoNodes");

        input.setAction("DescribeMongoNodes");
        if (QCStringUtil.isEmpty(this.zone)) {
            input.setZone(this.envContext.getZone());
        } else {
            input.setZone(this.zone);
        }

        Object backModel = ResourceRequestFactory.getResourceRequest().sendApiRequest(context, input,DescribeMongoNodesOutput.class);
        if(backModel != null){
            return (DescribeMongoNodesOutput)backModel;
        }
        return null;
    }

     /**
       * @param input
       * @param callback
       * @throws QCException
       *
       * Documentation URL: https://docs.qingcloud.com/api/mongo/describe_mongo_nodes.html
       */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void describeMongoNodes(DescribeMongoNodesInput input, ResponseCallBack<DescribeMongoNodesOutput> callback) throws QCException {
        if (input == null) {
            input = new DescribeMongoNodesInput();
        }
        Map context = new HashMap();
        context.put(QCConstant.ENV_CONTEXT_KEY, this.envContext);
        context.put("OperationName", "DescribeMongoNodes");
        context.put("APIName", "DescribeMongoNodes");
        context.put("ServiceName", "DescribeMongoNodes");
        context.put("RequestMethod", "GET");
        context.put("RequestURI", "/DescribeMongoNodes");

        input.setAction("DescribeMongoNodes");
        if (QCStringUtil.isEmpty(this.zone)) {
            input.setZone(this.envContext.getZone());
        } else {
            input.setZone(this.zone);
        }

        if(callback == null) {
            throw new QCException("callback can't be null");
        }

        ResourceRequestFactory.getResourceRequest().sendApiRequestAsync(context,input,callback);
    }

    public static class DescribeMongoNodesInput extends IaasParamBody {
        private Integer limit;

        @ParamAnnotation(paramType = "query", paramName = "limit")
        public void setLimit(Integer limit) {
            this.limit = limit;
        }

        @ParamAnnotation(paramType = "query", paramName = "limit")
        public Integer getLimit() {
            return this.limit;
        }

        // Required
        private String mongo;

        @ParamAnnotation(paramType = "query", paramName = "mongo")
        public void setMongo(String mongo) {
            this.mongo = mongo;
        }

        @ParamAnnotation(paramType = "query", paramName = "mongo")
        public String getMongo() {
            return this.mongo;
        }

        private Integer offset;

        @ParamAnnotation(paramType = "query", paramName = "offset")
        public void setOffset(Integer offset) {
            this.offset = offset;
        }

        @ParamAnnotation(paramType = "query", paramName = "offset")
        public Integer getOffset() {
            return this.offset;
        }

        private List<String> status;

        @ParamAnnotation(paramType = "query", paramName = "status")
        public void setStatus(List<String> status) {
            this.status = status;
        }

        @ParamAnnotation(paramType = "query", paramName = "status")
        public List<String> getStatus() {
            return this.status;
        }

        public String validateParam() throws QCException {
            if (QCStringUtil.isEmpty(this.getMongo())) {
                throw new QCException("Mongo is required");
            }
            return null;
        }
    }

    public static class DescribeMongoNodesOutput extends OutputModel {
        private String action;

        @ParamAnnotation(paramType = "query", paramName = "action")
        public void setAction(String action) {
            this.action = action;
        }

        @ParamAnnotation(paramType = "query", paramName = "action")
        public String getAction() {
            return this.action;
        }

        private List<MongoNodeModel> mongoNodeSet;

        @ParamAnnotation(paramType = "query", paramName = "mongo_node_set")
        public void setMongoNodeSet(List<MongoNodeModel> mongoNodeSet) {
            this.mongoNodeSet = mongoNodeSet;
        }

        @ParamAnnotation(paramType = "query", paramName = "mongo_node_set")
        public List<MongoNodeModel> getMongoNodeSet() {
            return this.mongoNodeSet;
        }

        private Integer retCode;

        @ParamAnnotation(paramType = "query", paramName = "ret_code")
        public void setRetCode(Integer retCode) {
            this.retCode = retCode;
        }

        @ParamAnnotation(paramType = "query", paramName = "ret_code")
        public Integer getRetCode() {
            return this.retCode;
        }

        private Integer totalCount;

        @ParamAnnotation(paramType = "query", paramName = "total_count")
        public void setTotalCount(Integer totalCount) {
            this.totalCount = totalCount;
        }

        @ParamAnnotation(paramType = "query", paramName = "total_count")
        public Integer getTotalCount() {
            return this.totalCount;
        }

    }
        
    /**
      * @param input
      * @throws QCException
      *
      * Documentation URL: https://docs.qingcloud.com/api/mongo/describe_mongo_parameters.html
      */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public DescribeMongoParametersOutput describeMongoParameters(DescribeMongoParametersInput input) throws QCException {
        if (input == null) {
            input = new DescribeMongoParametersInput();
        }
        Map context = new HashMap();
        context.put(QCConstant.ENV_CONTEXT_KEY, this.envContext);
        context.put("OperationName", "DescribeMongoParameters");
        context.put("APIName", "DescribeMongoParameters");
        context.put("ServiceName", "DescribeMongoParameters");
        context.put("RequestMethod", "GET");
        context.put("RequestURI", "/DescribeMongoParameters");

        input.setAction("DescribeMongoParameters");
        if (QCStringUtil.isEmpty(this.zone)) {
            input.setZone(this.envContext.getZone());
        } else {
            input.setZone(this.zone);
        }

        Object backModel = ResourceRequestFactory.getResourceRequest().sendApiRequest(context, input,DescribeMongoParametersOutput.class);
        if(backModel != null){
            return (DescribeMongoParametersOutput)backModel;
        }
        return null;
    }

     /**
       * @param input
       * @param callback
       * @throws QCException
       *
       * Documentation URL: https://docs.qingcloud.com/api/mongo/describe_mongo_parameters.html
       */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void describeMongoParameters(DescribeMongoParametersInput input, ResponseCallBack<DescribeMongoParametersOutput> callback) throws QCException {
        if (input == null) {
            input = new DescribeMongoParametersInput();
        }
        Map context = new HashMap();
        context.put(QCConstant.ENV_CONTEXT_KEY, this.envContext);
        context.put("OperationName", "DescribeMongoParameters");
        context.put("APIName", "DescribeMongoParameters");
        context.put("ServiceName", "DescribeMongoParameters");
        context.put("RequestMethod", "GET");
        context.put("RequestURI", "/DescribeMongoParameters");

        input.setAction("DescribeMongoParameters");
        if (QCStringUtil.isEmpty(this.zone)) {
            input.setZone(this.envContext.getZone());
        } else {
            input.setZone(this.zone);
        }

        if(callback == null) {
            throw new QCException("callback can't be null");
        }

        ResourceRequestFactory.getResourceRequest().sendApiRequestAsync(context,input,callback);
    }

    public static class DescribeMongoParametersInput extends IaasParamBody {
        private Integer limit;

        @ParamAnnotation(paramType = "query", paramName = "limit")
        public void setLimit(Integer limit) {
            this.limit = limit;
        }

        @ParamAnnotation(paramType = "query", paramName = "limit")
        public Integer getLimit() {
            return this.limit;
        }

        // Required
        private String mongo;

        @ParamAnnotation(paramType = "query", paramName = "mongo")
        public void setMongo(String mongo) {
            this.mongo = mongo;
        }

        @ParamAnnotation(paramType = "query", paramName = "mongo")
        public String getMongo() {
            return this.mongo;
        }

        private Integer offset;

        @ParamAnnotation(paramType = "query", paramName = "offset")
        public void setOffset(Integer offset) {
            this.offset = offset;
        }

        @ParamAnnotation(paramType = "query", paramName = "offset")
        public Integer getOffset() {
            return this.offset;
        }

        public String validateParam() throws QCException {
            if (QCStringUtil.isEmpty(this.getMongo())) {
                throw new QCException("Mongo is required");
            }
            return null;
        }
    }

    public static class DescribeMongoParametersOutput extends OutputModel {
        private String action;

        @ParamAnnotation(paramType = "query", paramName = "action")
        public void setAction(String action) {
            this.action = action;
        }

        @ParamAnnotation(paramType = "query", paramName = "action")
        public String getAction() {
            return this.action;
        }

        private List<MongoParameterModel> parameterSet;

        @ParamAnnotation(paramType = "query", paramName = "parameter_set")
        public void setParameterSet(List<MongoParameterModel> parameterSet) {
            this.parameterSet = parameterSet;
        }

        @ParamAnnotation(paramType = "query", paramName = "parameter_set")
        public List<MongoParameterModel> getParameterSet() {
            return this.parameterSet;
        }

        private Integer retCode;

        @ParamAnnotation(paramType = "query", paramName = "ret_code")
        public void setRetCode(Integer retCode) {
            this.retCode = retCode;
        }

        @ParamAnnotation(paramType = "query", paramName = "ret_code")
        public Integer getRetCode() {
            return this.retCode;
        }

        private Integer totalCount;

        @ParamAnnotation(paramType = "query", paramName = "total_count")
        public void setTotalCount(Integer totalCount) {
            this.totalCount = totalCount;
        }

        @ParamAnnotation(paramType = "query", paramName = "total_count")
        public Integer getTotalCount() {
            return this.totalCount;
        }

    }
        
    /**
      * @param input
      * @throws QCException
      *
      * Documentation URL: https://docs.qingcloud.com/api/mongo/describe_mongos.html
      */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public DescribeMongosOutput describeMongos(DescribeMongosInput input) throws QCException {
        if (input == null) {
            input = new DescribeMongosInput();
        }
        Map context = new HashMap();
        context.put(QCConstant.ENV_CONTEXT_KEY, this.envContext);
        context.put("OperationName", "DescribeMongos");
        context.put("APIName", "DescribeMongos");
        context.put("ServiceName", "DescribeMongos");
        context.put("RequestMethod", "GET");
        context.put("RequestURI", "/DescribeMongos");

        input.setAction("DescribeMongos");
        if (QCStringUtil.isEmpty(this.zone)) {
            input.setZone(this.envContext.getZone());
        } else {
            input.setZone(this.zone);
        }

        Object backModel = ResourceRequestFactory.getResourceRequest().sendApiRequest(context, input,DescribeMongosOutput.class);
        if(backModel != null){
            return (DescribeMongosOutput)backModel;
        }
        return null;
    }

     /**
       * @param input
       * @param callback
       * @throws QCException
       *
       * Documentation URL: https://docs.qingcloud.com/api/mongo/describe_mongos.html
       */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void describeMongos(DescribeMongosInput input, ResponseCallBack<DescribeMongosOutput> callback) throws QCException {
        if (input == null) {
            input = new DescribeMongosInput();
        }
        Map context = new HashMap();
        context.put(QCConstant.ENV_CONTEXT_KEY, this.envContext);
        context.put("OperationName", "DescribeMongos");
        context.put("APIName", "DescribeMongos");
        context.put("ServiceName", "DescribeMongos");
        context.put("RequestMethod", "GET");
        context.put("RequestURI", "/DescribeMongos");

        input.setAction("DescribeMongos");
        if (QCStringUtil.isEmpty(this.zone)) {
            input.setZone(this.envContext.getZone());
        } else {
            input.setZone(this.zone);
        }

        if(callback == null) {
            throw new QCException("callback can't be null");
        }

        ResourceRequestFactory.getResourceRequest().sendApiRequestAsync(context,input,callback);
    }

    public static class DescribeMongosInput extends IaasParamBody {
        private Integer limit;

        @ParamAnnotation(paramType = "query", paramName = "limit")
        public void setLimit(Integer limit) {
            this.limit = limit;
        }

        @ParamAnnotation(paramType = "query", paramName = "limit")
        public Integer getLimit() {
            return this.limit;
        }

        private String mongoName;

        @ParamAnnotation(paramType = "query", paramName = "mongo_name")
        public void setMongoName(String mongoName) {
            this.mongoName = mongoName;
        }

        @ParamAnnotation(paramType = "query", paramName = "mongo_name")
        public String getMongoName() {
            return this.mongoName;
        }

        private List<String> mongos;

        @ParamAnnotation(paramType = "query", paramName = "mongos")
        public void setMongos(List<String> mongos) {
            this.mongos = mongos;
        }

        @ParamAnnotation(paramType = "query", paramName = "mongos")
        public List<String> getMongos() {
            return this.mongos;
        }

        private Integer offset;

        @ParamAnnotation(paramType = "query", paramName = "offset")
        public void setOffset(Integer offset) {
            this.offset = offset;
        }

        @ParamAnnotation(paramType = "query", paramName = "offset")
        public Integer getOffset() {
            return this.offset;
        }

        private List<String> status;

        @ParamAnnotation(paramType = "query", paramName = "status")
        public void setStatus(List<String> status) {
            this.status = status;
        }

        @ParamAnnotation(paramType = "query", paramName = "status")
        public List<String> getStatus() {
            return this.status;
        }

        private List<String> tags;

        @ParamAnnotation(paramType = "query", paramName = "tags")
        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        @ParamAnnotation(paramType = "query", paramName = "tags")
        public List<String> getTags() {
            return this.tags;
        }

        private Integer verbose;

        @ParamAnnotation(paramType = "query", paramName = "verbose")
        public void setVerbose(Integer verbose) {
            this.verbose = verbose;
        }

        @ParamAnnotation(paramType = "query", paramName = "verbose")
        public Integer getVerbose() {
            return this.verbose;
        }

        public String validateParam() throws QCException {
            return null;
        }
    }

    public static class DescribeMongosOutput extends OutputModel {
        private String action;

        @ParamAnnotation(paramType = "query", paramName = "action")
        public void setAction(String action) {
            this.action = action;
        }

        @ParamAnnotation(paramType = "query", paramName = "action")
        public String getAction() {
            return this.action;
        }

        private List<MongoModel> mongoSet;

        @ParamAnnotation(paramType = "query", paramName = "mongo_set")
        public void setMongoSet(List<MongoModel> mongoSet) {
            this.mongoSet = mongoSet;
        }

        @ParamAnnotation(paramType = "query", paramName = "mongo_set")
        public List<MongoModel> getMongoSet() {
            return this.mongoSet;
        }

        private Integer retCode;

        @ParamAnnotation(paramType = "query", paramName = "ret_code")
        public void setRetCode(Integer retCode) {
            this.retCode = retCode;
        }

        @ParamAnnotation(paramType = "query", paramName = "ret_code")
        public Integer getRetCode() {
            return this.retCode;
        }

        private Integer totalCount;

        @ParamAnnotation(paramType = "query", paramName = "total_count")
        public void setTotalCount(Integer totalCount) {
            this.totalCount = totalCount;
        }

        @ParamAnnotation(paramType = "query", paramName = "total_count")
        public Integer getTotalCount() {
            return this.totalCount;
        }

    }
        
    /**
      * @param input
      * @throws QCException
      *
      * Documentation URL: https://docs.qingcloud.com/api/monitor/get_mongo_monitor.html
      */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public GetMongoMonitorOutput getMongoMonitor(GetMongoMonitorInput input) throws QCException {
        if (input == null) {
            input = new GetMongoMonitorInput();
        }
        Map context = new HashMap();
        context.put(QCConstant.ENV_CONTEXT_KEY, this.envContext);
        context.put("OperationName", "GetMongoMonitor");
        context.put("APIName", "GetMongoMonitor");
        context.put("ServiceName", "GetMongoMonitor");
        context.put("RequestMethod", "GET");
        context.put("RequestURI", "/GetMongoMonitor");

        input.setAction("GetMongoMonitor");
        if (QCStringUtil.isEmpty(this.zone)) {
            input.setZone(this.envContext.getZone());
        } else {
            input.setZone(this.zone);
        }

        Object backModel = ResourceRequestFactory.getResourceRequest().sendApiRequest(context, input,GetMongoMonitorOutput.class);
        if(backModel != null){
            return (GetMongoMonitorOutput)backModel;
        }
        return null;
    }

     /**
       * @param input
       * @param callback
       * @throws QCException
       *
       * Documentation URL: https://docs.qingcloud.com/api/monitor/get_mongo_monitor.html
       */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void getMongoMonitor(GetMongoMonitorInput input, ResponseCallBack<GetMongoMonitorOutput> callback) throws QCException {
        if (input == null) {
            input = new GetMongoMonitorInput();
        }
        Map context = new HashMap();
        context.put(QCConstant.ENV_CONTEXT_KEY, this.envContext);
        context.put("OperationName", "GetMongoMonitor");
        context.put("APIName", "GetMongoMonitor");
        context.put("ServiceName", "GetMongoMonitor");
        context.put("RequestMethod", "GET");
        context.put("RequestURI", "/GetMongoMonitor");

        input.setAction("GetMongoMonitor");
        if (QCStringUtil.isEmpty(this.zone)) {
            input.setZone(this.envContext.getZone());
        } else {
            input.setZone(this.zone);
        }

        if(callback == null) {
            throw new QCException("callback can't be null");
        }

        ResourceRequestFactory.getResourceRequest().sendApiRequestAsync(context,input,callback);
    }

    public static class GetMongoMonitorInput extends IaasParamBody {
        // Required
        private String endTime;

        @ParamAnnotation(paramType = "query", paramName = "end_time")
        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        @ParamAnnotation(paramType = "query", paramName = "end_time")
        public String getEndTime() {
            return this.endTime;
        }

        // Required
        private List<String> meters;

        @ParamAnnotation(paramType = "query", paramName = "meters")
        public void setMeters(List<String> meters) {
            this.meters = meters;
        }

        @ParamAnnotation(paramType = "query", paramName = "meters")
        public List<String> getMeters() {
            return this.meters;
        }

        // Required
        private String resource;

        @ParamAnnotation(paramType = "query", paramName = "resource")
        public void setResource(String resource) {
            this.resource = resource;
        }

        @ParamAnnotation(paramType = "query", paramName = "resource")
        public String getResource() {
            return this.resource;
        }

        // Required
        private String startTime;

        @ParamAnnotation(paramType = "query", paramName = "start_time")
        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        @ParamAnnotation(paramType = "query", paramName = "start_time")
        public String getStartTime() {
            return this.startTime;
        }

    	// Step's available values: 5m, 15m, 2h, 1d
        // Required
        private String step;

        @ParamAnnotation(paramType = "query", paramName = "step")
        public void setStep(String step) {
            this.step = step;
        }

        @ParamAnnotation(paramType = "query", paramName = "step")
        public String getStep() {
            return this.step;
        }

        public String validateParam() throws QCException {
            if (QCStringUtil.isEmpty(this.getResource())) {
                throw new QCException("Resource is required");
            }
            if (QCStringUtil.isEmpty(this.getStep())) {
                throw new QCException("Step is required");
            }
            String[] stepValidValues = {
                "5m", "15m", "2h", "1d"
            };

            boolean stepIsValid = false;
            for (String v : stepValidValues) {
                if (v.equals(this.getStep())) {
                    stepIsValid = true;
                }
                Boolean stepIsRequired = Boolean.TRUE;
                if (stepIsRequired.equals(Boolean.FALSE) && this.getStep() == null) {
                    stepIsValid = true;
                }
            }

            if (!stepIsValid) {
                throw new QCException("Step value " + this.getStep() + "is invalid");
            }
            return null;
        }
    }

    public static class GetMongoMonitorOutput extends OutputModel {
        private String action;

        @ParamAnnotation(paramType = "query", paramName = "action")
        public void setAction(String action) {
            this.action = action;
        }

        @ParamAnnotation(paramType = "query", paramName = "action")
        public String getAction() {
            return this.action;
        }

        private List<MeterModel> meterSet;

        @ParamAnnotation(paramType = "query", paramName = "meter_set")
        public void setMeterSet(List<MeterModel> meterSet) {
            this.meterSet = meterSet;
        }

        @ParamAnnotation(paramType = "query", paramName = "meter_set")
        public List<MeterModel> getMeterSet() {
            return this.meterSet;
        }

        private String resourceID;

        @ParamAnnotation(paramType = "query", paramName = "resource_id")
        public void setResourceID(String resourceID) {
            this.resourceID = resourceID;
        }

        @ParamAnnotation(paramType = "query", paramName = "resource_id")
        public String getResourceID() {
            return this.resourceID;
        }

        private Integer retCode;

        @ParamAnnotation(paramType = "query", paramName = "ret_code")
        public void setRetCode(Integer retCode) {
            this.retCode = retCode;
        }

        @ParamAnnotation(paramType = "query", paramName = "ret_code")
        public Integer getRetCode() {
            return this.retCode;
        }

    }
        
    /**
      * @param input
      * @throws QCException
      *
      * Documentation URL: https://docs.qingcloud.com/api/mongo/modify_mongo_attributes.html
      */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public ModifyMongoAttributesOutput modifyMongoAttributes(ModifyMongoAttributesInput input) throws QCException {
        if (input == null) {
            input = new ModifyMongoAttributesInput();
        }
        Map context = new HashMap();
        context.put(QCConstant.ENV_CONTEXT_KEY, this.envContext);
        context.put("OperationName", "ModifyMongoAttributes");
        context.put("APIName", "ModifyMongoAttributes");
        context.put("ServiceName", "ModifyMongoAttributes");
        context.put("RequestMethod", "GET");
        context.put("RequestURI", "/ModifyMongoAttributes");

        input.setAction("ModifyMongoAttributes");
        if (QCStringUtil.isEmpty(this.zone)) {
            input.setZone(this.envContext.getZone());
        } else {
            input.setZone(this.zone);
        }

        Object backModel = ResourceRequestFactory.getResourceRequest().sendApiRequest(context, input,ModifyMongoAttributesOutput.class);
        if(backModel != null){
            return (ModifyMongoAttributesOutput)backModel;
        }
        return null;
    }

     /**
       * @param input
       * @param callback
       * @throws QCException
       *
       * Documentation URL: https://docs.qingcloud.com/api/mongo/modify_mongo_attributes.html
       */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void modifyMongoAttributes(ModifyMongoAttributesInput input, ResponseCallBack<ModifyMongoAttributesOutput> callback) throws QCException {
        if (input == null) {
            input = new ModifyMongoAttributesInput();
        }
        Map context = new HashMap();
        context.put(QCConstant.ENV_CONTEXT_KEY, this.envContext);
        context.put("OperationName", "ModifyMongoAttributes");
        context.put("APIName", "ModifyMongoAttributes");
        context.put("ServiceName", "ModifyMongoAttributes");
        context.put("RequestMethod", "GET");
        context.put("RequestURI", "/ModifyMongoAttributes");

        input.setAction("ModifyMongoAttributes");
        if (QCStringUtil.isEmpty(this.zone)) {
            input.setZone(this.envContext.getZone());
        } else {
            input.setZone(this.zone);
        }

        if(callback == null) {
            throw new QCException("callback can't be null");
        }

        ResourceRequestFactory.getResourceRequest().sendApiRequestAsync(context,input,callback);
    }

    public static class ModifyMongoAttributesInput extends IaasParamBody {
        private Integer autoBackupTime;

        @ParamAnnotation(paramType = "query", paramName = "auto_backup_time")
        public void setAutoBackupTime(Integer autoBackupTime) {
            this.autoBackupTime = autoBackupTime;
        }

        @ParamAnnotation(paramType = "query", paramName = "auto_backup_time")
        public Integer getAutoBackupTime() {
            return this.autoBackupTime;
        }

        private String description;

        @ParamAnnotation(paramType = "query", paramName = "description")
        public void setDescription(String description) {
            this.description = description;
        }

        @ParamAnnotation(paramType = "query", paramName = "description")
        public String getDescription() {
            return this.description;
        }

        // Required
        private String mongo;

        @ParamAnnotation(paramType = "query", paramName = "mongo")
        public void setMongo(String mongo) {
            this.mongo = mongo;
        }

        @ParamAnnotation(paramType = "query", paramName = "mongo")
        public String getMongo() {
            return this.mongo;
        }

        private String mongoName;

        @ParamAnnotation(paramType = "query", paramName = "mongo_name")
        public void setMongoName(String mongoName) {
            this.mongoName = mongoName;
        }

        @ParamAnnotation(paramType = "query", paramName = "mongo_name")
        public String getMongoName() {
            return this.mongoName;
        }

        public String validateParam() throws QCException {
            if (QCStringUtil.isEmpty(this.getMongo())) {
                throw new QCException("Mongo is required");
            }
            return null;
        }
    }

    public static class ModifyMongoAttributesOutput extends OutputModel {
        private String action;

        @ParamAnnotation(paramType = "query", paramName = "action")
        public void setAction(String action) {
            this.action = action;
        }

        @ParamAnnotation(paramType = "query", paramName = "action")
        public String getAction() {
            return this.action;
        }

        private String mongo;

        @ParamAnnotation(paramType = "query", paramName = "mongo")
        public void setMongo(String mongo) {
            this.mongo = mongo;
        }

        @ParamAnnotation(paramType = "query", paramName = "mongo")
        public String getMongo() {
            return this.mongo;
        }

        private Integer retCode;

        @ParamAnnotation(paramType = "query", paramName = "ret_code")
        public void setRetCode(Integer retCode) {
            this.retCode = retCode;
        }

        @ParamAnnotation(paramType = "query", paramName = "ret_code")
        public Integer getRetCode() {
            return this.retCode;
        }

    }
        
    /**
      * @param input
      * @throws QCException
      *
      * Documentation URL: https://docs.qingcloud.com/api/mongo/modify_mongo_instances.html
      */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public ModifyMongoInstancesOutput modifyMongoInstances(ModifyMongoInstancesInput input) throws QCException {
        if (input == null) {
            input = new ModifyMongoInstancesInput();
        }
        Map context = new HashMap();
        context.put(QCConstant.ENV_CONTEXT_KEY, this.envContext);
        context.put("OperationName", "ModifyMongoInstances");
        context.put("APIName", "ModifyMongoInstances");
        context.put("ServiceName", "ModifyMongoInstances");
        context.put("RequestMethod", "GET");
        context.put("RequestURI", "/ModifyMongoInstances");

        input.setAction("ModifyMongoInstances");
        if (QCStringUtil.isEmpty(this.zone)) {
            input.setZone(this.envContext.getZone());
        } else {
            input.setZone(this.zone);
        }

        Object backModel = ResourceRequestFactory.getResourceRequest().sendApiRequest(context, input,ModifyMongoInstancesOutput.class);
        if(backModel != null){
            return (ModifyMongoInstancesOutput)backModel;
        }
        return null;
    }

     /**
       * @param input
       * @param callback
       * @throws QCException
       *
       * Documentation URL: https://docs.qingcloud.com/api/mongo/modify_mongo_instances.html
       */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void modifyMongoInstances(ModifyMongoInstancesInput input, ResponseCallBack<ModifyMongoInstancesOutput> callback) throws QCException {
        if (input == null) {
            input = new ModifyMongoInstancesInput();
        }
        Map context = new HashMap();
        context.put(QCConstant.ENV_CONTEXT_KEY, this.envContext);
        context.put("OperationName", "ModifyMongoInstances");
        context.put("APIName", "ModifyMongoInstances");
        context.put("ServiceName", "ModifyMongoInstances");
        context.put("RequestMethod", "GET");
        context.put("RequestURI", "/ModifyMongoInstances");

        input.setAction("ModifyMongoInstances");
        if (QCStringUtil.isEmpty(this.zone)) {
            input.setZone(this.envContext.getZone());
        } else {
            input.setZone(this.zone);
        }

        if(callback == null) {
            throw new QCException("callback can't be null");
        }

        ResourceRequestFactory.getResourceRequest().sendApiRequestAsync(context,input,callback);
    }

    public static class ModifyMongoInstancesInput extends IaasParamBody {
        // Required
        private String mongo;

        @ParamAnnotation(paramType = "query", paramName = "mongo")
        public void setMongo(String mongo) {
            this.mongo = mongo;
        }

        @ParamAnnotation(paramType = "query", paramName = "mongo")
        public String getMongo() {
            return this.mongo;
        }

        private List<MongoPrivateIPModel> privateIPs;

        @ParamAnnotation(paramType = "query", paramName = "private_ips")
        public void setPrivateIPs(List<MongoPrivateIPModel> privateIPs) {
            this.privateIPs = privateIPs;
        }

        @ParamAnnotation(paramType = "query", paramName = "private_ips")
        public List<MongoPrivateIPModel> getPrivateIPs() {
            return this.privateIPs;
        }

        public String validateParam() throws QCException {
            if (QCStringUtil.isEmpty(this.getMongo())) {
                throw new QCException("Mongo is required");
            }
            if (this.getPrivateIPs() != null && this.getPrivateIPs().size() > 0 ) {
                for (int i = 0 ; i < this.getPrivateIPs().size(); i++ ) {
                    
                    return null;

                    //if (!QCStringUtil.isEmpty(vValidate)) {
                    //    return vValidate;
                    // }
                }
            }
            return null;
        }
    }

    public static class ModifyMongoInstancesOutput extends OutputModel {
        private String action;

        @ParamAnnotation(paramType = "query", paramName = "action")
        public void setAction(String action) {
            this.action = action;
        }

        @ParamAnnotation(paramType = "query", paramName = "action")
        public String getAction() {
            return this.action;
        }

        private String jobID;

        @ParamAnnotation(paramType = "query", paramName = "job_id")
        public void setJobID(String jobID) {
            this.jobID = jobID;
        }

        @ParamAnnotation(paramType = "query", paramName = "job_id")
        public String getJobID() {
            return this.jobID;
        }

        private String mongo;

        @ParamAnnotation(paramType = "query", paramName = "mongo")
        public void setMongo(String mongo) {
            this.mongo = mongo;
        }

        @ParamAnnotation(paramType = "query", paramName = "mongo")
        public String getMongo() {
            return this.mongo;
        }

        private Integer retCode;

        @ParamAnnotation(paramType = "query", paramName = "ret_code")
        public void setRetCode(Integer retCode) {
            this.retCode = retCode;
        }

        @ParamAnnotation(paramType = "query", paramName = "ret_code")
        public Integer getRetCode() {
            return this.retCode;
        }

    }
        
    /**
      * @param input
      * @throws QCException
      *
      * Documentation URL: https://docs.qingcloud.com/api/mongo/remove_mongo_instances.html
      */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public RemoveMongoInstancesOutput removeMongoInstances(RemoveMongoInstancesInput input) throws QCException {
        if (input == null) {
            input = new RemoveMongoInstancesInput();
        }
        Map context = new HashMap();
        context.put(QCConstant.ENV_CONTEXT_KEY, this.envContext);
        context.put("OperationName", "RemoveMongoInstances");
        context.put("APIName", "RemoveMongoInstances");
        context.put("ServiceName", "RemoveMongoInstances");
        context.put("RequestMethod", "GET");
        context.put("RequestURI", "/RemoveMongoInstances");

        input.setAction("RemoveMongoInstances");
        if (QCStringUtil.isEmpty(this.zone)) {
            input.setZone(this.envContext.getZone());
        } else {
            input.setZone(this.zone);
        }

        Object backModel = ResourceRequestFactory.getResourceRequest().sendApiRequest(context, input,RemoveMongoInstancesOutput.class);
        if(backModel != null){
            return (RemoveMongoInstancesOutput)backModel;
        }
        return null;
    }

     /**
       * @param input
       * @param callback
       * @throws QCException
       *
       * Documentation URL: https://docs.qingcloud.com/api/mongo/remove_mongo_instances.html
       */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void removeMongoInstances(RemoveMongoInstancesInput input, ResponseCallBack<RemoveMongoInstancesOutput> callback) throws QCException {
        if (input == null) {
            input = new RemoveMongoInstancesInput();
        }
        Map context = new HashMap();
        context.put(QCConstant.ENV_CONTEXT_KEY, this.envContext);
        context.put("OperationName", "RemoveMongoInstances");
        context.put("APIName", "RemoveMongoInstances");
        context.put("ServiceName", "RemoveMongoInstances");
        context.put("RequestMethod", "GET");
        context.put("RequestURI", "/RemoveMongoInstances");

        input.setAction("RemoveMongoInstances");
        if (QCStringUtil.isEmpty(this.zone)) {
            input.setZone(this.envContext.getZone());
        } else {
            input.setZone(this.zone);
        }

        if(callback == null) {
            throw new QCException("callback can't be null");
        }

        ResourceRequestFactory.getResourceRequest().sendApiRequestAsync(context,input,callback);
    }

    public static class RemoveMongoInstancesInput extends IaasParamBody {
        // Required
        private String mongo;

        @ParamAnnotation(paramType = "query", paramName = "mongo")
        public void setMongo(String mongo) {
            this.mongo = mongo;
        }

        @ParamAnnotation(paramType = "query", paramName = "mongo")
        public String getMongo() {
            return this.mongo;
        }

        // Required
        private List<String> mongoInstances;

        @ParamAnnotation(paramType = "query", paramName = "mongo_instances")
        public void setMongoInstances(List<String> mongoInstances) {
            this.mongoInstances = mongoInstances;
        }

        @ParamAnnotation(paramType = "query", paramName = "mongo_instances")
        public List<String> getMongoInstances() {
            return this.mongoInstances;
        }

        public String validateParam() throws QCException {
            if (QCStringUtil.isEmpty(this.getMongo())) {
                throw new QCException("Mongo is required");
            }
            return null;
        }
    }

    public static class RemoveMongoInstancesOutput extends OutputModel {
        private String action;

        @ParamAnnotation(paramType = "query", paramName = "action")
        public void setAction(String action) {
            this.action = action;
        }

        @ParamAnnotation(paramType = "query", paramName = "action")
        public String getAction() {
            return this.action;
        }

        private String jobID;

        @ParamAnnotation(paramType = "query", paramName = "job_id")
        public void setJobID(String jobID) {
            this.jobID = jobID;
        }

        @ParamAnnotation(paramType = "query", paramName = "job_id")
        public String getJobID() {
            return this.jobID;
        }

        private String mongo;

        @ParamAnnotation(paramType = "query", paramName = "mongo")
        public void setMongo(String mongo) {
            this.mongo = mongo;
        }

        @ParamAnnotation(paramType = "query", paramName = "mongo")
        public String getMongo() {
            return this.mongo;
        }

        private Integer retCode;

        @ParamAnnotation(paramType = "query", paramName = "ret_code")
        public void setRetCode(Integer retCode) {
            this.retCode = retCode;
        }

        @ParamAnnotation(paramType = "query", paramName = "ret_code")
        public Integer getRetCode() {
            return this.retCode;
        }

    }
        
    /**
      * @param input
      * @throws QCException
      *
      * Documentation URL: https://docs.qingcloud.com/api/mongo/resize_mongos.html
      */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public ResizeMongosOutput resizeMongos(ResizeMongosInput input) throws QCException {
        if (input == null) {
            input = new ResizeMongosInput();
        }
        Map context = new HashMap();
        context.put(QCConstant.ENV_CONTEXT_KEY, this.envContext);
        context.put("OperationName", "ResizeMongos");
        context.put("APIName", "ResizeMongos");
        context.put("ServiceName", "ResizeMongos");
        context.put("RequestMethod", "GET");
        context.put("RequestURI", "/ResizeMongos");

        input.setAction("ResizeMongos");
        if (QCStringUtil.isEmpty(this.zone)) {
            input.setZone(this.envContext.getZone());
        } else {
            input.setZone(this.zone);
        }

        Object backModel = ResourceRequestFactory.getResourceRequest().sendApiRequest(context, input,ResizeMongosOutput.class);
        if(backModel != null){
            return (ResizeMongosOutput)backModel;
        }
        return null;
    }

     /**
       * @param input
       * @param callback
       * @throws QCException
       *
       * Documentation URL: https://docs.qingcloud.com/api/mongo/resize_mongos.html
       */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void resizeMongos(ResizeMongosInput input, ResponseCallBack<ResizeMongosOutput> callback) throws QCException {
        if (input == null) {
            input = new ResizeMongosInput();
        }
        Map context = new HashMap();
        context.put(QCConstant.ENV_CONTEXT_KEY, this.envContext);
        context.put("OperationName", "ResizeMongos");
        context.put("APIName", "ResizeMongos");
        context.put("ServiceName", "ResizeMongos");
        context.put("RequestMethod", "GET");
        context.put("RequestURI", "/ResizeMongos");

        input.setAction("ResizeMongos");
        if (QCStringUtil.isEmpty(this.zone)) {
            input.setZone(this.envContext.getZone());
        } else {
            input.setZone(this.zone);
        }

        if(callback == null) {
            throw new QCException("callback can't be null");
        }

        ResourceRequestFactory.getResourceRequest().sendApiRequestAsync(context,input,callback);
    }

    public static class ResizeMongosInput extends IaasParamBody {
        private Integer mongoType;

        @ParamAnnotation(paramType = "query", paramName = "mongo_type")
        public void setMongoType(Integer mongoType) {
            this.mongoType = mongoType;
        }

        @ParamAnnotation(paramType = "query", paramName = "mongo_type")
        public Integer getMongoType() {
            return this.mongoType;
        }

        // Required
        private List<String> mongos;

        @ParamAnnotation(paramType = "query", paramName = "mongos")
        public void setMongos(List<String> mongos) {
            this.mongos = mongos;
        }

        @ParamAnnotation(paramType = "query", paramName = "mongos")
        public List<String> getMongos() {
            return this.mongos;
        }

        private Integer storageSize;

        @ParamAnnotation(paramType = "query", paramName = "storage_size")
        public void setStorageSize(Integer storageSize) {
            this.storageSize = storageSize;
        }

        @ParamAnnotation(paramType = "query", paramName = "storage_size")
        public Integer getStorageSize() {
            return this.storageSize;
        }

        public String validateParam() throws QCException {
            return null;
        }
    }

    public static class ResizeMongosOutput extends OutputModel {
        private String action;

        @ParamAnnotation(paramType = "query", paramName = "action")
        public void setAction(String action) {
            this.action = action;
        }

        @ParamAnnotation(paramType = "query", paramName = "action")
        public String getAction() {
            return this.action;
        }

        private String jobID;

        @ParamAnnotation(paramType = "query", paramName = "job_id")
        public void setJobID(String jobID) {
            this.jobID = jobID;
        }

        @ParamAnnotation(paramType = "query", paramName = "job_id")
        public String getJobID() {
            return this.jobID;
        }

        private List<String> mongos;

        @ParamAnnotation(paramType = "query", paramName = "mongos")
        public void setMongos(List<String> mongos) {
            this.mongos = mongos;
        }

        @ParamAnnotation(paramType = "query", paramName = "mongos")
        public List<String> getMongos() {
            return this.mongos;
        }

        private Integer retCode;

        @ParamAnnotation(paramType = "query", paramName = "ret_code")
        public void setRetCode(Integer retCode) {
            this.retCode = retCode;
        }

        @ParamAnnotation(paramType = "query", paramName = "ret_code")
        public Integer getRetCode() {
            return this.retCode;
        }

    }
        
    /**
      * @param input
      * @throws QCException
      *
      * Documentation URL: https://docs.qingcloud.com/api/mongo/start_mongos.html
      */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public StartMongosOutput startMongos(StartMongosInput input) throws QCException {
        if (input == null) {
            input = new StartMongosInput();
        }
        Map context = new HashMap();
        context.put(QCConstant.ENV_CONTEXT_KEY, this.envContext);
        context.put("OperationName", "StartMongos");
        context.put("APIName", "StartMongos");
        context.put("ServiceName", "StartMongos");
        context.put("RequestMethod", "GET");
        context.put("RequestURI", "/StartMongos");

        input.setAction("StartMongos");
        if (QCStringUtil.isEmpty(this.zone)) {
            input.setZone(this.envContext.getZone());
        } else {
            input.setZone(this.zone);
        }

        Object backModel = ResourceRequestFactory.getResourceRequest().sendApiRequest(context, input,StartMongosOutput.class);
        if(backModel != null){
            return (StartMongosOutput)backModel;
        }
        return null;
    }

     /**
       * @param input
       * @param callback
       * @throws QCException
       *
       * Documentation URL: https://docs.qingcloud.com/api/mongo/start_mongos.html
       */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void startMongos(StartMongosInput input, ResponseCallBack<StartMongosOutput> callback) throws QCException {
        if (input == null) {
            input = new StartMongosInput();
        }
        Map context = new HashMap();
        context.put(QCConstant.ENV_CONTEXT_KEY, this.envContext);
        context.put("OperationName", "StartMongos");
        context.put("APIName", "StartMongos");
        context.put("ServiceName", "StartMongos");
        context.put("RequestMethod", "GET");
        context.put("RequestURI", "/StartMongos");

        input.setAction("StartMongos");
        if (QCStringUtil.isEmpty(this.zone)) {
            input.setZone(this.envContext.getZone());
        } else {
            input.setZone(this.zone);
        }

        if(callback == null) {
            throw new QCException("callback can't be null");
        }

        ResourceRequestFactory.getResourceRequest().sendApiRequestAsync(context,input,callback);
    }

    public static class StartMongosInput extends IaasParamBody {
        // Required
        private String mongos;

        @ParamAnnotation(paramType = "query", paramName = "mongos")
        public void setMongos(String mongos) {
            this.mongos = mongos;
        }

        @ParamAnnotation(paramType = "query", paramName = "mongos")
        public String getMongos() {
            return this.mongos;
        }

        public String validateParam() throws QCException {
            if (QCStringUtil.isEmpty(this.getMongos())) {
                throw new QCException("Mongos is required");
            }
            return null;
        }
    }

    public static class StartMongosOutput extends OutputModel {
        private String action;

        @ParamAnnotation(paramType = "query", paramName = "action")
        public void setAction(String action) {
            this.action = action;
        }

        @ParamAnnotation(paramType = "query", paramName = "action")
        public String getAction() {
            return this.action;
        }

        private String jobID;

        @ParamAnnotation(paramType = "query", paramName = "job_id")
        public void setJobID(String jobID) {
            this.jobID = jobID;
        }

        @ParamAnnotation(paramType = "query", paramName = "job_id")
        public String getJobID() {
            return this.jobID;
        }

        private Integer retCode;

        @ParamAnnotation(paramType = "query", paramName = "ret_code")
        public void setRetCode(Integer retCode) {
            this.retCode = retCode;
        }

        @ParamAnnotation(paramType = "query", paramName = "ret_code")
        public Integer getRetCode() {
            return this.retCode;
        }

    }
        
    /**
      * @param input
      * @throws QCException
      *
      * Documentation URL: https://docs.qingcloud.com/api/mongo/stop_mongos.html
      */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public StopMongosOutput stopMongos(StopMongosInput input) throws QCException {
        if (input == null) {
            input = new StopMongosInput();
        }
        Map context = new HashMap();
        context.put(QCConstant.ENV_CONTEXT_KEY, this.envContext);
        context.put("OperationName", "StopMongos");
        context.put("APIName", "StopMongos");
        context.put("ServiceName", "StopMongos");
        context.put("RequestMethod", "GET");
        context.put("RequestURI", "/StopMongos");

        input.setAction("StopMongos");
        if (QCStringUtil.isEmpty(this.zone)) {
            input.setZone(this.envContext.getZone());
        } else {
            input.setZone(this.zone);
        }

        Object backModel = ResourceRequestFactory.getResourceRequest().sendApiRequest(context, input,StopMongosOutput.class);
        if(backModel != null){
            return (StopMongosOutput)backModel;
        }
        return null;
    }

     /**
       * @param input
       * @param callback
       * @throws QCException
       *
       * Documentation URL: https://docs.qingcloud.com/api/mongo/stop_mongos.html
       */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void stopMongos(StopMongosInput input, ResponseCallBack<StopMongosOutput> callback) throws QCException {
        if (input == null) {
            input = new StopMongosInput();
        }
        Map context = new HashMap();
        context.put(QCConstant.ENV_CONTEXT_KEY, this.envContext);
        context.put("OperationName", "StopMongos");
        context.put("APIName", "StopMongos");
        context.put("ServiceName", "StopMongos");
        context.put("RequestMethod", "GET");
        context.put("RequestURI", "/StopMongos");

        input.setAction("StopMongos");
        if (QCStringUtil.isEmpty(this.zone)) {
            input.setZone(this.envContext.getZone());
        } else {
            input.setZone(this.zone);
        }

        if(callback == null) {
            throw new QCException("callback can't be null");
        }

        ResourceRequestFactory.getResourceRequest().sendApiRequestAsync(context,input,callback);
    }

    public static class StopMongosInput extends IaasParamBody {
        // Required
        private List<String> mongos;

        @ParamAnnotation(paramType = "query", paramName = "mongos")
        public void setMongos(List<String> mongos) {
            this.mongos = mongos;
        }

        @ParamAnnotation(paramType = "query", paramName = "mongos")
        public List<String> getMongos() {
            return this.mongos;
        }

        public String validateParam() throws QCException {
            return null;
        }
    }

    public static class StopMongosOutput extends OutputModel {
        private String action;

        @ParamAnnotation(paramType = "query", paramName = "action")
        public void setAction(String action) {
            this.action = action;
        }

        @ParamAnnotation(paramType = "query", paramName = "action")
        public String getAction() {
            return this.action;
        }

        private String jobID;

        @ParamAnnotation(paramType = "query", paramName = "job_id")
        public void setJobID(String jobID) {
            this.jobID = jobID;
        }

        @ParamAnnotation(paramType = "query", paramName = "job_id")
        public String getJobID() {
            return this.jobID;
        }

        private Integer retCode;

        @ParamAnnotation(paramType = "query", paramName = "ret_code")
        public void setRetCode(Integer retCode) {
            this.retCode = retCode;
        }

        @ParamAnnotation(paramType = "query", paramName = "ret_code")
        public Integer getRetCode() {
            return this.retCode;
        }

    }}


















