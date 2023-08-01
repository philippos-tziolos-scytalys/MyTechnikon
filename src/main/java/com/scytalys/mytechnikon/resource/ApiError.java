package com.scytalys.mytechnikon.resource;

public record ApiError(Integer status, String message, String path) {
}

