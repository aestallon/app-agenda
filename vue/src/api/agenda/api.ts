/* tslint:disable */
/* eslint-disable */
/**
 * Agenda API
 * A simple API to allow server-client communications
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: papp.szabolcs.bazil@gmail.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


import type { Configuration } from './configuration';
import type { AxiosPromise, AxiosInstance, AxiosRequestConfig } from 'axios';
import globalAxios from 'axios';
// Some imports not used depending on template conditions
// @ts-ignore
import { DUMMY_BASE_URL, assertParamExists, setApiKeyToObject, setBasicAuthToObject, setBearerAuthToObject, setOAuthToObject, setSearchParams, serializeDataIfNeeded, toPathString, createRequestFunction } from './common';
import type { RequestArgs } from './base';
// @ts-ignore
import { BASE_PATH, COLLECTION_FORMATS, BaseAPI, RequiredError } from './base';

/**
 * 
 * @export
 * @interface Task
 */
export interface Task {
    /**
     * Unique identifier of a given task. 
     * @type {number}
     * @memberof Task
     */
    'id'?: number;
    /**
     * 
     * @type {string}
     * @memberof Task
     */
    'title': string;
    /**
     * 
     * @type {string}
     * @memberof Task
     */
    'description'?: string;
    /**
     * 
     * @type {boolean}
     * @memberof Task
     */
    'completed': boolean;
    /**
     * 
     * @type {boolean}
     * @memberof Task
     */
    'important': boolean;
}

/**
 * AgendaApi - axios parameter creator
 * @export
 */
export const AgendaApiAxiosParamCreator = function (configuration?: Configuration) {
    return {
        /**
         * ...
         * @summary Create a new item in the agenda.
         * @param {Task} task 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        createTask: async (task: Task, options: AxiosRequestConfig = {}): Promise<RequestArgs> => {
            // verify required parameter 'task' is not null or undefined
            assertParamExists('createTask', 'task', task)
            const localVarPath = `/agenda`;
            // use dummy base URL string because the URL constructor only accepts absolute URLs.
            const localVarUrlObj = new URL(localVarPath, DUMMY_BASE_URL);
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }

            const localVarRequestOptions = { method: 'POST', ...baseOptions, ...options};
            const localVarHeaderParameter = {} as any;
            const localVarQueryParameter = {} as any;


    
            localVarHeaderParameter['Content-Type'] = 'application/json';

            setSearchParams(localVarUrlObj, localVarQueryParameter);
            let headersFromBaseOptions = baseOptions && baseOptions.headers ? baseOptions.headers : {};
            localVarRequestOptions.headers = {...localVarHeaderParameter, ...headersFromBaseOptions, ...options.headers};
            localVarRequestOptions.data = serializeDataIfNeeded(task, localVarRequestOptions, configuration)

            return {
                url: toPathString(localVarUrlObj),
                options: localVarRequestOptions,
            };
        },
        /**
         * ...
         * @summary Delete a task in the agenda
         * @param {number} id 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        deleteTask: async (id: number, options: AxiosRequestConfig = {}): Promise<RequestArgs> => {
            // verify required parameter 'id' is not null or undefined
            assertParamExists('deleteTask', 'id', id)
            const localVarPath = `/agenda/{id}`
                .replace(`{${"id"}}`, encodeURIComponent(String(id)));
            // use dummy base URL string because the URL constructor only accepts absolute URLs.
            const localVarUrlObj = new URL(localVarPath, DUMMY_BASE_URL);
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }

            const localVarRequestOptions = { method: 'DELETE', ...baseOptions, ...options};
            const localVarHeaderParameter = {} as any;
            const localVarQueryParameter = {} as any;


    
            setSearchParams(localVarUrlObj, localVarQueryParameter);
            let headersFromBaseOptions = baseOptions && baseOptions.headers ? baseOptions.headers : {};
            localVarRequestOptions.headers = {...localVarHeaderParameter, ...headersFromBaseOptions, ...options.headers};

            return {
                url: toPathString(localVarUrlObj),
                options: localVarRequestOptions,
            };
        },
        /**
         * ...
         * @summary List all items in the agenda.
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        getAllTasks: async (options: AxiosRequestConfig = {}): Promise<RequestArgs> => {
            const localVarPath = `/agenda`;
            // use dummy base URL string because the URL constructor only accepts absolute URLs.
            const localVarUrlObj = new URL(localVarPath, DUMMY_BASE_URL);
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }

            const localVarRequestOptions = { method: 'GET', ...baseOptions, ...options};
            const localVarHeaderParameter = {} as any;
            const localVarQueryParameter = {} as any;


    
            setSearchParams(localVarUrlObj, localVarQueryParameter);
            let headersFromBaseOptions = baseOptions && baseOptions.headers ? baseOptions.headers : {};
            localVarRequestOptions.headers = {...localVarHeaderParameter, ...headersFromBaseOptions, ...options.headers};

            return {
                url: toPathString(localVarUrlObj),
                options: localVarRequestOptions,
            };
        },
        /**
         * ...
         * @summary Update a task in the agenda
         * @param {number} id 
         * @param {Task} task 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        updateTask: async (id: number, task: Task, options: AxiosRequestConfig = {}): Promise<RequestArgs> => {
            // verify required parameter 'id' is not null or undefined
            assertParamExists('updateTask', 'id', id)
            // verify required parameter 'task' is not null or undefined
            assertParamExists('updateTask', 'task', task)
            const localVarPath = `/agenda/{id}`
                .replace(`{${"id"}}`, encodeURIComponent(String(id)));
            // use dummy base URL string because the URL constructor only accepts absolute URLs.
            const localVarUrlObj = new URL(localVarPath, DUMMY_BASE_URL);
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }

            const localVarRequestOptions = { method: 'PUT', ...baseOptions, ...options};
            const localVarHeaderParameter = {} as any;
            const localVarQueryParameter = {} as any;


    
            localVarHeaderParameter['Content-Type'] = 'application/json';

            setSearchParams(localVarUrlObj, localVarQueryParameter);
            let headersFromBaseOptions = baseOptions && baseOptions.headers ? baseOptions.headers : {};
            localVarRequestOptions.headers = {...localVarHeaderParameter, ...headersFromBaseOptions, ...options.headers};
            localVarRequestOptions.data = serializeDataIfNeeded(task, localVarRequestOptions, configuration)

            return {
                url: toPathString(localVarUrlObj),
                options: localVarRequestOptions,
            };
        },
    }
};

/**
 * AgendaApi - functional programming interface
 * @export
 */
export const AgendaApiFp = function(configuration?: Configuration) {
    const localVarAxiosParamCreator = AgendaApiAxiosParamCreator(configuration)
    return {
        /**
         * ...
         * @summary Create a new item in the agenda.
         * @param {Task} task 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async createTask(task: Task, options?: AxiosRequestConfig): Promise<(axios?: AxiosInstance, basePath?: string) => AxiosPromise<Task>> {
            const localVarAxiosArgs = await localVarAxiosParamCreator.createTask(task, options);
            return createRequestFunction(localVarAxiosArgs, globalAxios, BASE_PATH, configuration);
        },
        /**
         * ...
         * @summary Delete a task in the agenda
         * @param {number} id 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async deleteTask(id: number, options?: AxiosRequestConfig): Promise<(axios?: AxiosInstance, basePath?: string) => AxiosPromise<void>> {
            const localVarAxiosArgs = await localVarAxiosParamCreator.deleteTask(id, options);
            return createRequestFunction(localVarAxiosArgs, globalAxios, BASE_PATH, configuration);
        },
        /**
         * ...
         * @summary List all items in the agenda.
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async getAllTasks(options?: AxiosRequestConfig): Promise<(axios?: AxiosInstance, basePath?: string) => AxiosPromise<Array<Task>>> {
            const localVarAxiosArgs = await localVarAxiosParamCreator.getAllTasks(options);
            return createRequestFunction(localVarAxiosArgs, globalAxios, BASE_PATH, configuration);
        },
        /**
         * ...
         * @summary Update a task in the agenda
         * @param {number} id 
         * @param {Task} task 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async updateTask(id: number, task: Task, options?: AxiosRequestConfig): Promise<(axios?: AxiosInstance, basePath?: string) => AxiosPromise<Task>> {
            const localVarAxiosArgs = await localVarAxiosParamCreator.updateTask(id, task, options);
            return createRequestFunction(localVarAxiosArgs, globalAxios, BASE_PATH, configuration);
        },
    }
};

/**
 * AgendaApi - factory interface
 * @export
 */
export const AgendaApiFactory = function (configuration?: Configuration, basePath?: string, axios?: AxiosInstance) {
    const localVarFp = AgendaApiFp(configuration)
    return {
        /**
         * ...
         * @summary Create a new item in the agenda.
         * @param {Task} task 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        createTask(task: Task, options?: any): AxiosPromise<Task> {
            return localVarFp.createTask(task, options).then((request) => request(axios, basePath));
        },
        /**
         * ...
         * @summary Delete a task in the agenda
         * @param {number} id 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        deleteTask(id: number, options?: any): AxiosPromise<void> {
            return localVarFp.deleteTask(id, options).then((request) => request(axios, basePath));
        },
        /**
         * ...
         * @summary List all items in the agenda.
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        getAllTasks(options?: any): AxiosPromise<Array<Task>> {
            return localVarFp.getAllTasks(options).then((request) => request(axios, basePath));
        },
        /**
         * ...
         * @summary Update a task in the agenda
         * @param {number} id 
         * @param {Task} task 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        updateTask(id: number, task: Task, options?: any): AxiosPromise<Task> {
            return localVarFp.updateTask(id, task, options).then((request) => request(axios, basePath));
        },
    };
};

/**
 * AgendaApi - object-oriented interface
 * @export
 * @class AgendaApi
 * @extends {BaseAPI}
 */
export class AgendaApi extends BaseAPI {
    /**
     * ...
     * @summary Create a new item in the agenda.
     * @param {Task} task 
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof AgendaApi
     */
    public createTask(task: Task, options?: AxiosRequestConfig) {
        return AgendaApiFp(this.configuration).createTask(task, options).then((request) => request(this.axios, this.basePath));
    }

    /**
     * ...
     * @summary Delete a task in the agenda
     * @param {number} id 
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof AgendaApi
     */
    public deleteTask(id: number, options?: AxiosRequestConfig) {
        return AgendaApiFp(this.configuration).deleteTask(id, options).then((request) => request(this.axios, this.basePath));
    }

    /**
     * ...
     * @summary List all items in the agenda.
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof AgendaApi
     */
    public getAllTasks(options?: AxiosRequestConfig) {
        return AgendaApiFp(this.configuration).getAllTasks(options).then((request) => request(this.axios, this.basePath));
    }

    /**
     * ...
     * @summary Update a task in the agenda
     * @param {number} id 
     * @param {Task} task 
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof AgendaApi
     */
    public updateTask(id: number, task: Task, options?: AxiosRequestConfig) {
        return AgendaApiFp(this.configuration).updateTask(id, task, options).then((request) => request(this.axios, this.basePath));
    }
}


